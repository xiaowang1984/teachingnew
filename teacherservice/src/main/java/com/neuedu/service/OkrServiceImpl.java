package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.pojo.Okr;
import com.neuedu.dao.OkrMapper;
import com.neuedu.service.IOkrService;
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
 * @since 2020-01-12
 */
@Service
@Component
public class OkrServiceImpl extends ServiceImpl<OkrMapper, Okr> implements IOkrService {

    @Override
    public Okr getOkr(Okr okr) {
        QueryWrapper<Okr> wrapper = new QueryWrapper<>();
        wrapper.eq("type",okr.getType()).eq("relationid",okr.getRelationid());
        Okr result = getOne(wrapper);
        result.setList(list(result));
        return  result;
    }

    @Override
    public List<Okr> list(Okr okr) {
        QueryWrapper<Okr> wrapper = new QueryWrapper<>();
        wrapper.eq("parentid",okr.getId());
        List<Okr> okrs = list(wrapper);
        for (Okr o: okrs) {
            o.setList(list(o));
        }
        return okrs;
    }
}
