package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Course;
import com.neuedu.dao.CourseMapper;
import com.neuedu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2019-08-20
 */
@Service
@Component
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Resource
    CourseMapper courseMapper;
    @Override
    public IPage<Course> page(Course course) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if(course.getIsDel()!=null)
            queryWrapper.eq("is_del",course.getIsDel());
        if(StringUtils.isNotBlank(course.getName()))
            queryWrapper.eq("name",course.getName());
        return this.page(new Page<>(course.getPageNo(),course.getPageSize()),queryWrapper);
    }

    @Override
    public List<Course> list(Course course) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if(course.getIsDel()!=null)
            queryWrapper.eq("is_del",course.getIsDel());
        if(StringUtils.isNotBlank(course.getName()))
            queryWrapper.eq("name",course.getName());
        return this.list(queryWrapper);
    }
}
