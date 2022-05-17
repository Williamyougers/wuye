package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class ResultVo {
    private Integer code;
    private String message;
    private Boolean success;
    private Object data;
}
