package com.xiedang.www.utils.object;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象工具类
 */
public class ObjectUtil {

    /**
     * map装换成指定对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = beanClass.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    /**
     * 对象转换成map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>(16);
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    /**
     * 根据方法名和参数获取指定对象的方法名的值
     * @param methodName 方法名
     * @param obj 指定对象
     * @param objects 方法参数
     * @return 返回对象
     */
    public static Object getMethodValue(String methodName, Object obj, Object... objects) throws Exception{
        Object methodValue=null;
        if(null==obj || StringUtils.isBlank(methodName)){
            return null;
        }
        Method[] methods = obj.getClass().getDeclaredMethods();
        if(null==methods){
            return null;
        }
        for (Method m:methods) {
           if(m.getName().equalsIgnoreCase(methodName)){
               methodValue=m.invoke(obj,objects);
           }
        }
        return methodValue;
    }
}
