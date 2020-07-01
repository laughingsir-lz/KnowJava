package com.lz.listday02.generalpractice03;

import java.util.Set;

/**
 * @ClassName Department
 * @Description:
 * @Author: zzz
 **/
public class Department {
    private String deptName;
    private Set<Employee> emps;
    public Department() {
    }
    public Department(String deptName, Set<Employee> emps) {
        this.deptName = deptName;
        this.emps = emps;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Set<Employee> getEmps() {
        return emps;
    }
    public void setEmps(Set<Employee> emps) {
        this.emps = emps;
    }
    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
