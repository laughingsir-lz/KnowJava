package com.lz.ssm.qo;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    private boolean success;
    private String msg;

    public JsonResult(String msg) {
        this.msg = msg;
    }
}
