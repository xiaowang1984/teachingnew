package com.neuedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.pojo.Imgbytes;
import com.neuedu.dao.ImgbytesMapper;
import com.neuedu.service.IImgbytesService;
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
 * @since 2020-02-22
 */
@Service
@Component
public class ImgbytesServiceImpl extends ServiceImpl<ImgbytesMapper, Imgbytes> implements IImgbytesService {
    @Resource
    ImgbytesMapper imgbytesMapper;
    @Override
    public IPage<Imgbytes> page(Imgbytes imgbytes) {
        QueryWrapper<Imgbytes> wrapper = new QueryWrapper<>();
        return this.page(new Page<>(imgbytes.getPageNo(),imgbytes.getPageSize()),wrapper);
    }
    @Override
    public List<Imgbytes> list(Imgbytes imgbytes) {
        QueryWrapper<Imgbytes> wrapper = new QueryWrapper<>();
        return list(wrapper);
    }
}
