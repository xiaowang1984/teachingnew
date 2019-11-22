package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-08-20
 */
public interface ICourseService extends IService<Course> {
    IPage<Course> page(Course course);
    List<Course> list(Course course);
}
