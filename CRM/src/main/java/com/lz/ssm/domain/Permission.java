package com.lz.ssm.domain;

import lombok.ToString;

@ToString
public class Permission {
    private Long id;

    private String name;

    private String expression;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getexpression() {
        return expression;
    }

    public void setexpression(String expression) {
        this.expression = expression;
    }
}