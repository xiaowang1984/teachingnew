package com.neuedu.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.neuedu.bus.Result;
import com.neuedu.pojo.Teacher;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyu on 2019/8/14.
 */
@Aspect
@Component
public class MyAop {
    @AfterReturning(value="execution(* com.neuedu.controller.LoginController.login(..))",returning = "val")
    public Result token(Result val){
        if(val.getData()!=null){
            Teacher teacher = (Teacher)val.getData();
            Map<String,Object> map = new HashMap<>();
            String token = JWT.create().withJWTId(teacher.getNo())
                    .sign(Algorithm.HMAC256(teacher.getPassword()));
            map.put("teacher",teacher);
            map.put("token",token);
            val.setData(map);
        }
        return val;
    }
}
