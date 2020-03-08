package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.dao.OkrMapper;
import com.neuedu.pojo.Neueducase;
import com.neuedu.dao.NeueducaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import com.neuedu.pojo.Okr;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2020-01-10
 */
@Service
@Component
public class NeueducaseServiceImpl extends ServiceImpl<NeueducaseMapper, Neueducase> implements INeueducaseService {
    @Resource
    IOkrService okrService;
    @Override
    public IPage<Neueducase> page(Neueducase neueducase) {
        QueryWrapper<Neueducase> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(neueducase.getName()))
        wrapper.like("name","%"+neueducase.getName()+"%");
        if(neueducase.getIsDel()!=null)
        wrapper.eq("is_del",neueducase.getIsDel());
        return this.page(new Page<>(neueducase.getPageNo(),neueducase.getPageSize()),wrapper);
    }
    @Override
    public List<Neueducase> list(Neueducase neueducase) {
        QueryWrapper<Neueducase> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(neueducase.getName()))
            wrapper.like("name", neueducase.getName());
        if(neueducase.getIsDel()!=null)
            wrapper.eq("is_del", neueducase.getIsDel());
        return list(wrapper);
    }

    @Override
    @Transactional
    public boolean casesave(Neueducase neueducase) {
        boolean result;
        if(null == neueducase.getId()) {
            result = saveOrUpdate(neueducase);
            Okr okr = new Okr();
            okr.setType(1);
            okr.setRelationid(neueducase.getId());
            okr.setName(neueducase.getName());
            okrService.save(okr);
        }else {
            result = saveOrUpdate(neueducase);
            Okr okr = new Okr();
            okr.setName(neueducase.getName());
            UpdateWrapper<Okr> okrWrapper = new UpdateWrapper<>();
            okrWrapper.eq("type",1).eq("relationid",neueducase.getId());
            okrService.update(okr,okrWrapper);
        }
        return result;
    }
}
