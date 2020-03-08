package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Knowledge;
import com.neuedu.dao.KnowledgeMapper;
import com.neuedu.service.IKnowledgeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2019-11-25
 */
@Service
@Component
public class KnowledgeServiceImpl extends ServiceImpl<KnowledgeMapper, Knowledge> implements IKnowledgeService {

    @Override
    public IPage<Knowledge> page(Knowledge knowledge) {
        QueryWrapper<Knowledge> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(knowledge.getName()))
            wrapper.like("name","%"+knowledge.getName()+"%");
        if(knowledge.getIsDel()!=null)
            wrapper.eq("is_del",knowledge.getIsDel());
        return this.page(new Page<>(knowledge.getPageNo(),knowledge.getPageSize()),wrapper);
    }

    @Override
    public List<Knowledge> list(Knowledge knowledge) {
        QueryWrapper<Knowledge> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(knowledge.getName()))
            wrapper.like("name", knowledge.getName());
        if(knowledge.getIsDel()!=null)
            wrapper.eq("is_del", knowledge.getIsDel());
        return list(wrapper);
    }
}
