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
 * 技术表
 * </p>
 *
 * @author wangyu
 * @since 2019-08-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Skill extends Pagination implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 技术名称
     */
    private String name;

    /**
     * 上级id,顶级为0
     */
    private Integer parentId;

    /**
     * 是否有效
     */
    private Integer isDel;

    /**
     * 难度等级
     */
    private Integer level;
    /**
     * 层级
     */
    private Integer rank;
    /**
     * 排序
     */
    private Integer sort;


    /**
     * 描述
     */
    private String description;

    /**
     * 下级技术
     * */
    @TableField(exist = false)
    private List<Skill> children;
}
