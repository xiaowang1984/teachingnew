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
 * @since 2019-11-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Knowledge extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 知识点名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;

    /**
     * 知识点关联
     */
    private String abilityInfoIds;

    /**
     * 是否翻转 0=N 1=Y
     */
    private Integer flip;

    /**
     * 视频地址
     */
    private String url;

    /**
     * 时长
     */
    private Long duration;

    private Integer isDel;


}
