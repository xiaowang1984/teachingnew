package com.neuedu.pojo;

import com.neuedu.bus.Pagination;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class Imgs extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件MD5码
     */
    private String md5;

    /**
     * 文件路径
     */
    private String url;


}
