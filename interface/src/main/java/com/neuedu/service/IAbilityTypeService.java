package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.AbilityType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-01-07
 */
public interface IAbilityTypeService extends IService<AbilityType> {
    IPage<AbilityType> page(AbilityType abilityType);
    List<AbilityType> list(AbilityType abilityType);
}
