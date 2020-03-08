package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.PubStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 公开课学生信息登记 服务类
 * </p>
 *
 * @author wangyu
 * @since 2020-02-22
 */
public interface IPubStudentService extends IService<PubStudent> {
    IPage<PubStudent> page(PubStudent pubStudent);
    List<PubStudent> list(PubStudent pubStudent);
}
