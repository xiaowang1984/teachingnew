package com.neuedu.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.bus.Result;
import com.neuedu.util.PassToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangyu on 2019/8/14.
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Resource
    ObjectMapper objectMapper;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if(!handlerMethod.hasMethodAnnotation(PassToken.class)){
                String token=request.getHeader("token");
                System.out.println(token);
                if(StringUtils.isBlank(token)) {
                    response.getWriter().write(objectMapper.writeValueAsString(new Result(-1, null, "miss token")));
                    return false;
                }else{
                    try {
                        DecodedJWT decode = JWT.decode(token);
                        TeacherLocal.set(decode.getId());
                        return true;
                    }catch (Exception ex){
                        response.getWriter().write(objectMapper.writeValueAsString(new Result(-1, null, "miss token")));
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TeacherLocal.remove();
    }

}
