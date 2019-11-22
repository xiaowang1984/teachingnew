package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.AbilityInfo;
import com.neuedu.dao.AbilityInfoMapper;
import com.neuedu.service.IAbilityInfoService;
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
 * @since 2019-10-02
 */
@Service
@Component
public class AbilityInfoServiceImpl extends ServiceImpl<AbilityInfoMapper, AbilityInfo> implements IAbilityInfoService {

    @Override
    public IPage<AbilityInfo> page(AbilityInfo abilityInfo) {
        QueryWrapper<AbilityInfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityInfo.getName()))
            queryWrapper.like("name",abilityInfo.getName());
        if(abilityInfo.getIsDel()!=null)
            queryWrapper.eq("is_del",abilityInfo.getIsDel());
        return this.page(new Page<>(abilityInfo.getPageNo(),abilityInfo.getPageSize()),queryWrapper);
    }

    @Override
    public List<AbilityInfo> list(AbilityInfo abilityInfo) {
        QueryWrapper<AbilityInfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityInfo.getName()))
            queryWrapper.like("name",abilityInfo.getName());
        if(abilityInfo.getIsDel()!=null)
            queryWrapper.eq("is_del",abilityInfo.getIsDel());
        return this.list(queryWrapper);
    }
}
