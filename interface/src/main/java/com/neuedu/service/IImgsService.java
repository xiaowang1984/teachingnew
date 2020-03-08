package com.neuedu.service;

import com.neuedu.pojo.Imgs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-11-25
 */
public interface IImgsService extends IService<Imgs> {
    Imgs getImgByMD5(String MD5);
}
