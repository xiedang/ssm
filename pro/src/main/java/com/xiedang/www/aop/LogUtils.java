package com.xiedang.www.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtils {
    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);

    @Pointcut("execution(* com.xiedang.www.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        Object result = null;
        String methodName = pjp.getSignature().getName();
        try {
            //前置通知
            LOG.info("方法名:{},参数{}",methodName,Arrays.asList(pjp.getArgs()));
            result = pjp.proceed();
            LOG.info("方法名:{},结果{}",methodName,result);
        } catch (Throwable e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            LOG.info("方法名:{},执行了{}ms",methodName,elapsedTime);
        }
        return result;
    }

}
