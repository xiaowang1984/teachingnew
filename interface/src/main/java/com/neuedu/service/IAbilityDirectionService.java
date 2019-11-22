package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.AbilityDirection;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 能力方向,类似于语言管理 服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-09-18
 */
public interface IAbilityDirectionService extends IService<AbilityDirection> {
    IPage<AbilityDirection> page(AbilityDirection abilityDirection);
    List<AbilityDirection> list(AbilityDirection abilityDirection);
}
