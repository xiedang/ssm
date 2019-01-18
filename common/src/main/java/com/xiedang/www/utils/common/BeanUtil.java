package com.xiedang.www.utils.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 */
public class BeanUtil {

    private static final ThreadLocal THREADLOCAL=new ThreadLocal<>();

    /**
     * 根据xml文件获取指定bean名对应的bean
     * @param xmlName
     * @param beanName
     * @return
     */
    public static Object getBeanByXml(String xmlName,String beanName){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlName);
        Object obj = ctx.getBean(beanName);
        return obj;
    }

    /**
     * 单例获取和线程绑定的存储结构
     * @return
     */
    public static ThreadLocal getThreadLocal(){
        return THREADLOCAL;
    }

}
