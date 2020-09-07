package com.lz.ssm.qo;

import com.lz.ssm.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zzz
 * @date 2020/8/29  14:17
 */
@Getter
@Setter
public class CustomerReportQuery extends QueryObject {

    // 默认按人员分组
    private String groupType = "e.name";
    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    // 结束 时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Date getEndDate() {
        return DateUtil.getEndDate(endDate);
    }
}
