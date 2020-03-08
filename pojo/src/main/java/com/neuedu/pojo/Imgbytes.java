package com.neuedu.pojo;

import java.sql.Blob;
import java.io.Serializable;
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
 * @since 2020-02-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Imgbytes extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private String img;


}
