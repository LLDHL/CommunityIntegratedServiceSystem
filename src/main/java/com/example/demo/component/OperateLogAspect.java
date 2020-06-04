package com.example.demo.component;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.AdminOperateLogDao;
import com.example.demo.model.AdminOperateLog;
import com.example.demo.service.UserService;
import com.example.demo.untils.NetworkUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private AdminOperateLogDao adminOperateLogDao;

    @Autowired
    private UserService userService;

    @Pointcut("@annotation(com.example.demo.untils.OperateLog)")
    public void operateLogPoinCut() {
    }

    @Pointcut("execution(* com.example.demo.controller.AdminController.*(..))")
    public void operateExceptionLogPoinCut() {
    }

    @AfterReturning(value = "operateLogPoinCut()", returning = "keys")
    public void saveOperateLog(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        Map<String, String[]> rtnMap = request.getParameterMap();
        String parameter = JSON.toJSONString(rtnMap);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//当前登录的用户名
        Integer userId = userService.getUserId(username);

        AdminOperateLog log = new AdminOperateLog();
        try {
            log.setAdminId(userId);
            log.setDate(System.currentTimeMillis());
            log.setOperateIp(NetworkUtil.getIpAddress(request));
            log.setRequestMapping(request.getRequestURI());
            log.setRequestParameter(parameter);
            log.setReturnParameter(JSON.toJSONString(keys));

            adminOperateLogDao.insertLog(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
