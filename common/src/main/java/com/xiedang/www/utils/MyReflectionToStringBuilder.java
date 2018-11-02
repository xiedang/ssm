//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.xiedang.www.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class MyReflectionToStringBuilder extends ToStringBuilder {
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    private String arrayStart = "{";
    private String arraySeparator = ",";
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private String nullText = "<null>";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private boolean appendStatics = false;
    private boolean appendTransients = false;
    private String[] excludeFieldNames;
    private Class upToClass = null;

    public static String toString(Object object) {
        return toString(object, (ToStringStyle)null, false, false, (Class)null);
    }

    public static String toString(Object object, ToStringStyle style) {
        return toString(object, style, false, false, (Class)null);
    }

    public static String toString(Object object, ToStringStyle style, boolean outputTransients) {
        return toString(object, style, outputTransients, false, (Class)null);
    }

    public static String toString(Object object, ToStringStyle style, boolean outputTransients, boolean outputStatics) {
        return toString(object, style, outputTransients, outputStatics, (Class)null);
    }

    public static String toString(Object object, ToStringStyle style, boolean outputTransients, boolean outputStatics, Class reflectUpToClass) {
        return (new MyReflectionToStringBuilder(object, style, (StringBuffer)null, reflectUpToClass, outputTransients, outputStatics)).toString();
    }

    /** @deprecated */
    public static String toString(Object object, ToStringStyle style, boolean outputTransients, Class reflectUpToClass) {
        return (new MyReflectionToStringBuilder(object, style, (StringBuffer)null, reflectUpToClass, outputTransients)).toString();
    }

    public static String toStringExclude(Object object, String excludeFieldName) {
        return toStringExclude(object, new String[]{excludeFieldName});
    }

    public static String toStringExclude(Object object, Collection excludeFieldNames) {
        return toStringExclude(object, toNoNullStringArray(excludeFieldNames));
    }

    static String[] toNoNullStringArray(Collection collection) {
        return collection == null ? ArrayUtils.EMPTY_STRING_ARRAY : toNoNullStringArray(collection.toArray());
    }

    static String[] toNoNullStringArray(Object[] array) {
        ArrayList list = new ArrayList(array.length);

        for(int i = 0; i < array.length; ++i) {
            Object e = array[i];
            if (e != null) {
                list.add(e.toString());
            }
        }

        return (String[])list.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String toStringExclude(Object object, String[] excludeFieldNames) {
        return (new MyReflectionToStringBuilder(object)).setExcludeFieldNames(excludeFieldNames).toString();
    }

    public MyReflectionToStringBuilder(Object object) {
        super(object);
    }

    public MyReflectionToStringBuilder(Object object, ToStringStyle style) {
        super(object, style);
    }

    public MyReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
        super(object, style, buffer);
    }

    /** @deprecated */
    public MyReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer, Class reflectUpToClass, boolean outputTransients) {
        super(object, style, buffer);
        this.setUpToClass(reflectUpToClass);
        this.setAppendTransients(outputTransients);
    }

    public MyReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer, Class reflectUpToClass, boolean outputTransients, boolean outputStatics) {
        super(object, style, buffer);
        this.setUpToClass(reflectUpToClass);
        this.setAppendTransients(outputTransients);
        this.setAppendStatics(outputStatics);
    }

    protected boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        } else if (Modifier.isTransient(field.getModifiers()) && !this.isAppendTransients()) {
            return false;
        } else if (Modifier.isStatic(field.getModifiers()) && !this.isAppendStatics()) {
            return false;
        } else {
            return this.getExcludeFieldNames() == null || Arrays.binarySearch(this.getExcludeFieldNames(), field.getName()) < 0;
        }
    }

    protected void appendFieldsIn(Class clazz) {
        if (clazz.isArray()) {
            this.reflectionAppendArray(this.getObject());
        } else {
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                String fieldName = field.getName();
                if (this.accept(field)) {
                    try {
                        Object fieldValue = this.getValue(field);
                        if (fieldValue != null) {
                            this.append(fieldName, fieldValue);
                        }
                    } catch (IllegalAccessException var7) {
                        throw new InternalError("Unexpected IllegalAccessException: " + var7.getMessage());
                    }
                }
            }

        }
    }

    public String[] getExcludeFieldNames() {
        return this.excludeFieldNames;
    }

    public Class getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        return field.get(this.getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public ToStringBuilder reflectionAppendArray(Object array) {
        this.reflectionAppendArrayDetail(this.getStringBuffer(), (String)null, array);
        return this;
    }

    protected void reflectionAppendArrayDetail(StringBuffer buffer, String fieldName, Object array) {
        buffer.append(this.arrayStart);
        int length = Array.getLength(array);

        for(int i = 0; i < length; ++i) {
            Object item = Array.get(array, i);
            if (i > 0) {
                buffer.append(this.arraySeparator);
            }

            if (item == null) {
                buffer.append(this.nullText);
            } else {
                this.appendInternal(buffer, fieldName, item, this.arrayContentDetail);
            }
        }

        buffer.append(this.arrayEnd);
    }

    protected void appendInternal(StringBuffer buffer, String fieldName, Object value, boolean detail) {
        if (isRegistered(value) && !(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof Character)) {
            this.appendCyclicObject(buffer, fieldName, value);
        } else {
            register(value);

            try {
                if (value instanceof Collection) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, value);
                    } else {
                        this.appendSummarySize(buffer, fieldName, ((Collection)value).size());
                    }
                } else if (value instanceof Map) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, value);
                    } else {
                        this.appendSummarySize(buffer, fieldName, ((Map)value).size());
                    }
                } else if (value instanceof long[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (long[])value);
                    } else {
                        this.appendSummary(buffer, fieldName, (long[])value);
                    }
                } else if (value instanceof int[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, value);
                    } else {
                        this.appendSummary(buffer, fieldName, value);
                    }
                } else if (value instanceof short[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, value);
                    } else {
                        this.appendSummary(buffer, fieldName, (short[])value);
                    }
                } else if (value instanceof byte[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (byte[])value);
                    } else {
                        this.appendSummary(buffer, fieldName, (byte[])value);
                    }
                } else if (value instanceof char[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (char[])((char[])value));
                    } else {
                        this.appendSummary(buffer, fieldName, (char[])((char[])value));
                    }
                } else if (value instanceof double[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (double[])((double[])value));
                    } else {
                        this.appendSummary(buffer, fieldName, (double[])((double[])value));
                    }
                } else if (value instanceof float[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (float[])((float[])value));
                    } else {
                        this.appendSummary(buffer, fieldName, (float[])((float[])value));
                    }
                } else if (value instanceof boolean[]) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (boolean[])((boolean[])value));
                    } else {
                        this.appendSummary(buffer, fieldName, (boolean[])((boolean[])value));
                    }
                } else if (value.getClass().isArray()) {
                    if (detail) {
                        this.appendDetail(buffer, fieldName, (Object[])((Object[])value));
                    } else {
                        this.appendSummary(buffer, fieldName, (Object[])((Object[])value));
                    }
                } else if (detail) {
                    this.appendDetail(buffer, fieldName, value);
                } else {
                    this.appendSummary(buffer, fieldName, value);
                }
            } finally {
                unregister(value);
            }

        }
    }

    static boolean isRegistered(Object value) {
        Map m = getRegistry();
        return m != null && m.containsKey(value);
    }

    static void register(Object value) {
        if (value != null) {
            Map m = getRegistry();
            if (m == null) {
                m = new WeakHashMap();
                REGISTRY.set(m);
            }

            ((Map)m).put(value, (Object)null);
        }

    }

    static void unregister(Object value) {
        if (value != null) {
            Map m = getRegistry();
            if (m != null) {
                m.remove(value);
                if (m.isEmpty()) {
                    REGISTRY.set((Object)null);
                }
            }
        }

    }

    static Map getRegistry() {
        return (Map)REGISTRY.get();
    }

    protected void appendCyclicObject(StringBuffer buffer, String fieldName, Object value) {
        ObjectUtils.identityToString(buffer, value);
    }

    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        buffer.append(value);
    }

    protected void appendSummary(StringBuffer buffer, String fieldName, Object value) {
        buffer.append(this.summaryObjectStartText);
        buffer.append(this.getShortClassName(value.getClass()));
        buffer.append(this.summaryObjectEndText);
    }

    protected void appendSummarySize(StringBuffer buffer, String fieldName, int size) {
        buffer.append(this.sizeStartText);
        buffer.append(size);
        buffer.append(this.sizeEndText);
    }

    protected String getShortClassName(Class cls) {
        return ClassUtils.getShortClassName(cls);
    }

    public void setAppendStatics(boolean appendStatics) {
        this.appendStatics = appendStatics;
    }

    public void setAppendTransients(boolean appendTransients) {
        this.appendTransients = appendTransients;
    }

    public MyReflectionToStringBuilder setExcludeFieldNames(String[] excludeFieldNamesParam) {
        if (excludeFieldNamesParam == null) {
            this.excludeFieldNames = null;
        } else {
            this.excludeFieldNames = toNoNullStringArray((Object[])excludeFieldNamesParam);
            Arrays.sort(this.excludeFieldNames);
        }

        return this;
    }

    public void setUpToClass(Class clazz) {
        if (clazz != null) {
            Object object = this.getObject();
            if (object != null && !clazz.isInstance(object)) {
                throw new IllegalArgumentException("Specified class is not a superclass of the object");
            }
        }

        this.upToClass = clazz;
    }

    public String toString() {
        if (this.getObject() == null) {
            return this.nullText;
        } else {
            Class clazz = this.getObject().getClass();
            this.appendFieldsIn(clazz);

            while(clazz.getSuperclass() != null && clazz != this.getUpToClass()) {
                clazz = clazz.getSuperclass();
                this.appendFieldsIn(clazz);
            }

            return super.toString();
        }
    }
}
