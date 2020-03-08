package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.AbilityType;
import com.neuedu.dao.AbilityTypeMapper;
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
 * @since 2020-01-07
 */
@Service
@Component
public class AbilityTypeServiceImpl extends ServiceImpl<AbilityTypeMapper, AbilityType> implements IAbilityTypeService {
    @Override
    public IPage<AbilityType> page(AbilityType abilityType) {
        QueryWrapper<AbilityType> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityType.getName()))
        wrapper.like("name","%"+abilityType.getName()+"%");
        if(abilityType.getIsDel()!=null)
        wrapper.eq("is_del",abilityType.getIsDel());
        return this.page(new Page<>(abilityType.getPageNo(),abilityType.getPageSize()),wrapper);
    }
    @Override
    public List<AbilityType> list(AbilityType abilityType) {
        QueryWrapper<AbilityType> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(abilityType.getName()))
            wrapper.like("name", abilityType.getName());
        if(abilityType.getIsDel()!=null)
            wrapper.eq("is_del", abilityType.getIsDel());
        return list(wrapper);
    }
}
