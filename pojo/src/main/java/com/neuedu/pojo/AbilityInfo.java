package com.neuedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.neuedu.bus.Pagination;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyu
 * @since 2019-10-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AbilityInfo extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 能力名称
     */
    private String name;

    /**
     * 能力详情
     */
    private String description;

    /**
     * 能力方向
     */
    private Integer directionId;

    /**
     * 重要级别
     */
    private Integer level;
    /**
     * 知识点级联
     */
    private String skills;

    /**
     * 难度
     */
    private Integer difficulty;

    /**
     * 平衡能力
     */
    private String balanceAbility;

    /**
     * 保留字段
     */
    @TableField(exist=false)
    private String remark;

    /**
     * 是否有效
     */
    private Integer isDel;


}
