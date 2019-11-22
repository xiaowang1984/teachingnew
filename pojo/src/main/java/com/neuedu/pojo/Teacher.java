package com.neuedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Teacher extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工登录id
     */

    private String no;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 员工角色
     */
    private Integer type;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String mail;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 是否有效
     */
    private Integer isDel;


}
