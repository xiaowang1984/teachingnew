package com.neuedu.pojo;

import com.neuedu.bus.Pagination;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 能力方向,类似于语言管理
 * </p>
 *
 * @author wangyu
 * @since 2019-09-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AbilityDirection extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方向名
     */
    private String name;

    private Integer isDel;


}
