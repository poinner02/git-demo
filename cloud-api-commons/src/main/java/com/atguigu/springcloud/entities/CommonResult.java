package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author MrChen
 * @create 2021-12-10 15:13
 * return json 数据给前端
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String  message;
    private T       data;


    public  CommonResult(Integer code,String  message){
        this(code,message,null);
    }

}
