package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.bus.Result;
import com.neuedu.pojo.Skill;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 技术表 服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-08-23
 */
public interface ISkillService extends IService<Skill> {
    List<Skill> list(Skill skill);
    List<Skill> getSkillByRank(int rank);
    IPage<Skill> listByParent(Skill skill);
    boolean sort(Integer[] ids);
    boolean del(Integer id);
}
