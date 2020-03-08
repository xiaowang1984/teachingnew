package com.neuedu.pojo;

import java.time.LocalDate;
import java.io.Serializable;
import com.neuedu.bus.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyu
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Neueducase extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Integer type;

    private Integer abilityType;

    private Integer level;

    private LocalDate createDate;

    private String createId;

    private String standardVideo;

    private Boolean flip;

    private Boolean videoSolution;

    private Integer isDel;


}
