package com.neuedu.bus;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private Object data;
    private String message;

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code) {
        this.code = code;
        if(code>0)
            message="操作成功";
    }
    public Result(Boolean state){
        this(state?1:0);
    }
}
