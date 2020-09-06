package com.lz.restful.domain;

import com.sun.tracing.dtrace.NameAttributes;
import lombok.*;

import java.util.List;

/**
 * @author zzz
 * @date 2020/9/6  21:49
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees;
}
