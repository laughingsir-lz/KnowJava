package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zzz
 * @date 2020/8/31  18:26
 */
@ToString
@Getter
@Setter
public class SalaryQueryObject extends QueryObject {
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private Long payoutId;
}
