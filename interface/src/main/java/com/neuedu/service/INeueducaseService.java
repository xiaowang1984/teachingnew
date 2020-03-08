package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.Neueducase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-01-10
 */
public interface INeueducaseService extends IService<Neueducase> {
    IPage<Neueducase> page(Neueducase neueducase);
    List<Neueducase> list(Neueducase neueducase);
    boolean casesave(Neueducase neueducase);
}
