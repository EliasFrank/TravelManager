package com.hl.controller;

import com.hl.domain.SysLog;
import com.hl.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author hl2333
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;
    /**
     * 开始访问的时间
     */
    private Date visitTime;
    /**
     * 访问时长
     */
    private Long visit;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;
    /**
     * 访问的方法的名字
     */
    private String methodName;
    /**
     * 访问的地址
     */
    private String ip;
    /**
     * 访问者的名字
     */
    private String username;
    /**
     * 访问的url
     */
    String url = "";

    /**
     * 抽取可重用的切入点表达式
     */
    @Pointcut("execution(* com.hl.controller.*.*(..))")
    public void toolMethod(){}
    /**
     * 前置通知，获取开始的时间，执行的类和方法
     * @param joinPoint
     */
    @Before("toolMethod()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        String methodName;
        //获取开始访问的时间
        visitTime = new Date();
        //获取具体访问的类
        clazz = joinPoint.getTarget().getClass();
        //获取方法的名称
        methodName = joinPoint.getSignature().getName();
        //获取方法的参数列表
        Object[] args = joinPoint.getArgs();

        //获取具体执行方法的method对象
        if(args == null || args.length == 0){
            method = clazz.getMethod(methodName);
        }else{
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < classArgs.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    @After("toolMethod()")
    public void doAfter(JoinPoint joinPoint){
        //获取执行时长
        visit = System.currentTimeMillis() - visitTime.getTime();

        if (clazz != null && method != null && clazz != LogAop.class){
            methodName = method.getName();
            RequestMapping annotations =
                    (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(annotations != null){
                String[] value = annotations.value();
                url += value[0];
            }
            url += "/";
            RequestMapping meAnnotation =
                    (RequestMapping) method.getAnnotation(RequestMapping.class);
            if (meAnnotation != null){
                String[] value = meAnnotation.value();
                url += value[0];
            }
        }
        ip = request.getRemoteAddr();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User) securityContext.getAuthentication().getPrincipal();
        username = user.getUsername();

        save();
    }

    private void save() {
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(visit);
        sysLog.setIp(ip);
        sysLog.setMethod(methodName);
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);

        sysLogService.save(sysLog);
        url = "";
    }
}
