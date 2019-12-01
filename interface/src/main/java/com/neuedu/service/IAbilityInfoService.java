package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.AbilityDirection;
import com.neuedu.pojo.AbilityInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-10-02
 */
public interface IAbilityInfoService extends IService<AbilityInfo> {
    IPage<AbilityInfo> page(AbilityInfo abilityInfo);
    List<AbilityInfo> list(AbilityInfo abilityInfo);
    List<AbilityInfo> listByIds(List<Integer> ids);
}
