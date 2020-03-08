package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.bus.Result;
import com.neuedu.pojo.Skill;
import com.neuedu.dao.SkillMapper;
import com.neuedu.service.ISkillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 技术表 服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2019-08-23
 */
@Service
@Component
public class SkillServiceImpl extends ServiceImpl<SkillMapper, Skill> implements ISkillService {

    @Override
    public List<Skill> list(Skill skill) {
        List<Skill> list = getChildren(skill);
        System.out.println(list);
        return list;
    }

    private List<Skill> getChildren(Skill s){
        QueryWrapper<Skill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",s.getId());
        if(null != s.getIsDel())
            queryWrapper.eq("is_del",s.getIsDel());
        queryWrapper.orderByDesc("sort");
        List<Skill> list = this.list(queryWrapper);
        for(Skill skill : list)
            skill.setChildren(getChildren(skill));
        return list.size()==0?null:list;
    }
    public List<Skill> getSkillByRank(int rank){
        QueryWrapper<Skill> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name").eq("rank",rank).eq("is_del",1);
        return this.list(queryWrapper);
    }

    @Override
    public IPage<Skill> listByParent(Skill skill) {
        QueryWrapper<Skill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",skill.getId());
        if(StringUtils.isNotBlank(skill.getName()))
            queryWrapper.like("name","%"+skill.getName()+"%");
        if(null != skill.getIsDel())
            queryWrapper.eq("is_del",skill.getIsDel());
        queryWrapper.orderByAsc("sort");
        IPage<Skill> list = this.page(new Page<>(skill.getPageNo(),skill.getPageSize()),queryWrapper);
        return list;
    }

    @Override
    public boolean sort(Integer[] ids) {
        int sort = 1;
        for(Integer id : ids){
            Skill skill = new Skill();
            skill.setId(id);
            skill.setSort(sort);
            updateById(skill);
            sort++;
        }
        return true;
    }

    @Override
    public boolean del(Integer id) {
        return delByParentId(id);
    }
    private boolean delByParentId(Integer id){
        QueryWrapper<Skill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        List<Skill> skills = this.list(queryWrapper);
        for (Skill skill : skills){
            delByParentId(skill.getId());
        }
        return removeById(id);

    }
}
