package com.neuedu.pojo;

import com.neuedu.bus.Pagination;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyu
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AbilityType extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer isDel;


}
