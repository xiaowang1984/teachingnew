package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Imgs;
import com.neuedu.dao.ImgsMapper;
import com.neuedu.service.IImgsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyu
 * @since 2019-11-25
 */
@Service
@Component
public class ImgsServiceImpl extends ServiceImpl<ImgsMapper, Imgs> implements IImgsService {

    @Override
    public Imgs getImgByMD5(String MD5) {
        return getOne(new QueryWrapper<Imgs>().eq("md5", MD5));
    }
}
