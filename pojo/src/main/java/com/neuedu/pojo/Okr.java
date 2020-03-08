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
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Okr extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * okr名称
     */
    private String name;

    /**
     * 上级id
     */
    private Integer parentid;

    /**
     * 1-案例
     */
    private Integer type;

    /**
     * 关联id
     */
    private Integer relationid;

    @TableField(exist = false)
    private List<Okr> list;

    private Integer level;

    private Integer weight;

    private String skill;
}
