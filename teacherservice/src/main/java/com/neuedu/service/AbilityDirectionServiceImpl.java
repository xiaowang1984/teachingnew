package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.AbilityDirection;
import com.neuedu.dao.AbilityDirectionMapper;
import com.neuedu.service.IAbilityDirectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 能力方向,类似于语言管理 服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2019-09-18
 */
@Service
@Component
public class AbilityDirectionServiceImpl extends ServiceImpl<AbilityDirectionMapper, AbilityDirection> implements IAbilityDirectionService {
    @Resource
    AbilityDirectionMapper abilityDirectionMapper;
    @Override
    public IPage<AbilityDirection> page(AbilityDirection abilityDirection) {
        QueryWrapper<AbilityDirection> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityDirection.getName()))
            queryWrapper.like("name",abilityDirection.getName());
        if(abilityDirection.getIsDel()!=null)
            queryWrapper.eq("is_del",abilityDirection.getIsDel());
        return this.page(new Page<>(abilityDirection.getPageNo(),abilityDirection.getPageSize()),queryWrapper);
    }

    @Override
    public List<AbilityDirection> list(AbilityDirection abilityDirection) {
        QueryWrapper<AbilityDirection> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityDirection.getName()))
            queryWrapper.like("name",abilityDirection.getName());
        if(abilityDirection.getIsDel()!=null)
            queryWrapper.eq("is_del",abilityDirection.getIsDel());
        return this.list(queryWrapper);
    }
}
