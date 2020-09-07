package com.lz.ssm.util;

import com.lz.ssm.qo.CustomerReportQuery;

/**
 * @author zzz
 * @date 2020/8/31  13:26
 */
public abstract class MessageUtil {
    public static String changMsg(CustomerReportQuery qo) {
        String msg = null;
        switch (qo.getGroupType()) {
            case "DATE_FORMAT(c.input_time, '%Y')":
                msg = "年份";
                break;
            case "DATE_FORMAT(c.input_time, '%Y-%m')":
                msg = "月份";
                break;
            case "DATE_FORMAT(c.input_time, '%Y-%m-%d')":
                msg = "日期";
                break;
            default:
                msg = "员工";
        }
        return msg;
    }
}