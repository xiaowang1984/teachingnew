package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-08-14
 */
public interface ITeacherService extends IService<Teacher> {
    IPage<Teacher> page(Teacher teacher);
    List<Teacher> list(Teacher teacher);
    int checkNo(String no);
    Teacher getOne(String no);
    Collection<Teacher> getByIds(String ids);
}
