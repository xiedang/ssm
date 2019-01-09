package com.xiedang.www.aop;

import com.alibaba.fastjson.JSONObject;
import com.xiedang.www.mapper.SysOperateMessageMapper;
import com.xiedang.www.model.SysOperateMessage;
import com.xiedang.www.model.User;
import com.xiedang.www.utils.session.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LogUtils {
    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);
    @Autowired
    private SysOperateMessageMapper sysOperateMessageMapper;

    @Pointcut("execution(* com.xiedang.www.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        SysOperateMessage message=new SysOperateMessage();
        long start = System.currentTimeMillis();
        Object result = null;
        String methodName = pjp.getSignature().getName();
        try {
            //前置通知
            LOG.info("方法名:{},参数{}",methodName,Arrays.asList(pjp.getArgs()));
            Object[] args = pjp.getArgs();
            StringBuilder argsStr=new StringBuilder();
            for (Object arg : args) {
                if (!(arg instanceof ServletRequest
                        || arg instanceof ServletResponse
                        || arg instanceof HttpSession
                        || arg instanceof InputStreamSource)) {
                    argsStr.append(arg.toString()).append(",");
                }
            }
            if(StringUtils.isNotBlank(argsStr.toString())){
                argsStr.deleteCharAt(argsStr.length()-1);
            }
            message.setOperateParas(argsStr.toString());
            message.setOperateMethod(methodName);
            User user = (User)SessionUtil.getSessionAttribute("user");
            message.setOperator(user==null?null:user.getUsername());
            result = pjp.proceed();
            if(result instanceof ModelAndView){
                ModelAndView modelAndView=(ModelAndView)result;
                String res="viewName="+modelAndView.getViewName()+",model="+modelAndView.getModel();
                message.setReturnData(res);
            }else {
                String s = JSONObject.toJSONString(result);
                message.setReturnData(s);
            }
            LOG.info("方法名:{},结果{}",methodName,result);
        } catch (Throwable e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            message.setExecTime(elapsedTime+"ms");
            message.setOprateTime(new Date());
            sysOperateMessageMapper.insertSelective(message);
            LOG.info("方法名:{},执行了{}ms",methodName,elapsedTime);
        }
        return result;
    }

}
