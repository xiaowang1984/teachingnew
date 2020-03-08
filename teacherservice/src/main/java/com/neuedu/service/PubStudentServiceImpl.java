package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Okr;
import com.neuedu.pojo.PubStudent;
import com.neuedu.dao.PubStudentMapper;
import com.neuedu.service.IPubStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公开课学生信息登记 服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2020-02-22
 */
@Service
@Component
public class PubStudentServiceImpl extends ServiceImpl<PubStudentMapper, PubStudent> implements IPubStudentService {
    @Resource
    PubStudentMapper pubStudentMapper;
    @Override
    public IPage<PubStudent> page(PubStudent pubStudent) {
        QueryWrapper<PubStudent> wrapper = new QueryWrapper<>();
        if(pubStudent.getStart()!=null)
            wrapper.le("date",pubStudent.getStart());
        if(pubStudent.getEnd()!=null)
            wrapper.ge("date",pubStudent.getEnd());
        return this.page(new Page<>(pubStudent.getPageNo(),pubStudent.getPageSize()),wrapper);
    }
    @Override
    public List<PubStudent> list(PubStudent pubStudent) {
        QueryWrapper<PubStudent> wrapper = new QueryWrapper<>();
        if(pubStudent.getStart()!=null)
            wrapper.le("date",pubStudent.getStart());
        if(pubStudent.getEnd()!=null)
            wrapper.ge("date",pubStudent.getEnd());
        return list(wrapper);
    }
}
