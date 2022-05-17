package com.fc.vo;


import lombok.Data;

@Data
public class ResultVo {
    private Integer code;
    private String message;
    private Boolean success;
    private Object data;
}
