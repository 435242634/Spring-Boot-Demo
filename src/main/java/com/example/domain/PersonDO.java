package com.example.domain;

import java.io.Serializable;

/**
 * Created by FlySheep on 17/3/24.
 */
public class PersonDO implements Serializable {
    private static final long serialVersionUID = -5554561712056198940L;

    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
