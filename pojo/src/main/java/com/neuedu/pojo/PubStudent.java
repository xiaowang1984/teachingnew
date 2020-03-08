package com.neuedu.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.neuedu.bus.Pagination;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公开课学生信息登记
 * </p>
 *
 * @author wangyu
 * @since 2020-02-22
 */

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
public class PubStudent extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 所在院校
     */
    private String school;

    private String phone;

    private LocalDateTime date;

    @TableField(exist = false)
    private LocalDateTime start;
    @TableField(exist = false)
    private LocalDateTime end;


}
