package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.pojo.Knowledge;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyu
 * @since 2019-11-25
 */
public interface IKnowledgeService extends IService<Knowledge> {
    IPage<Knowledge> page(Knowledge knowledge);
    List<Knowledge> list(Knowledge knowledge);
}
