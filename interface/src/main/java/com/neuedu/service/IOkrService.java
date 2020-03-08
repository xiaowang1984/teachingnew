package com.neuedu.service;

import com.neuedu.pojo.Okr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-01-12
 */
public interface IOkrService extends IService<Okr> {
    Okr getOkr(Okr okr);
    List<Okr> list(Okr okr);

}
