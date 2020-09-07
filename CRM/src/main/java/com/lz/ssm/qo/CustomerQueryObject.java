package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zzz
 * @date 2020/8/29  14:17
 */
@Getter
@Setter
public class CustomerQueryObject extends QueryObject {
    private Integer status;
    private Long sellerId;
    private Long customerId;
}
