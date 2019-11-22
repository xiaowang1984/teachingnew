package com.neuedu.bus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Pagination {
    @TableId(value = "id",type=IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Integer pageNo=1;
    @TableField(exist = false)
    private Integer pageSize=10;
    @TableField(exist = false)
    private Integer withPage=1;

}
