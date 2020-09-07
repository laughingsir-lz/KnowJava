package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zzz
 * @date 2020/8/27  19:54
 */
@Setter
@Getter
@ToString
public class SystemDictionaryItemQueryObject extends QueryObject {
    private Integer parentId = 1;
}
