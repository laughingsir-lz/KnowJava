package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PermissionQueryObject extends QueryObject {
    private String keyword;
    private Long roleId;
}
