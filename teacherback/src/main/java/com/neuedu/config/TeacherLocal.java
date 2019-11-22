package com.neuedu.config;

import com.neuedu.pojo.Teacher;

/**
 * Created by wangyu on 2019/8/16.
 */
public class TeacherLocal {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String get() {
        return threadLocal.get();
    }

    public static void set(String id) {
        threadLocal.set(id);
    }
    public static void remove(){
        threadLocal.remove();
    }
}
