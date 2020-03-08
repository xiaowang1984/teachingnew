package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.Imgbytes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-02-22
 */
public interface IImgbytesService extends IService<Imgbytes> {
    IPage<Imgbytes> page(Imgbytes imgbytes);
    List<Imgbytes> list(Imgbytes imgbytes);
}
