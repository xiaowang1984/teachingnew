package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Teacher;
import com.neuedu.dao.TeacherMapper;
import com.neuedu.service.ITeacherService;
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
 * @since 2019-08-14
 */
@Service
@Component
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public IPage<Teacher> page(Teacher teacher) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(teacher.getName()))
            wrapper.like("name","%"+teacher.getName()+"%");
        if(teacher.getIsDel()!=null)
            wrapper.eq("is_del",teacher.getIsDel());
        if(teacher.getType()!=null)
            wrapper.eq("type", teacher.getType());
        return this.page(new Page<>(teacher.getPageNo(),teacher.getPageSize()),wrapper);
    }

    @Override
    public List<Teacher> list(Teacher teacher) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(teacher.getName()))
            wrapper.like("name", teacher.getName());
        if(teacher.getIsDel()!=null)
            wrapper.eq("is_del", teacher.getIsDel());
        if(teacher.getType()!=null)
            wrapper.eq("type", teacher.getType());
        return list(wrapper);
    }

    @Override
    public int checkNo(String no) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("no", no);
        return count(wrapper);
    }

    @Override
    public Teacher getOne(String no) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("no",no.trim());
        return teacherMapper.selectOne(wrapper);
    }
}
