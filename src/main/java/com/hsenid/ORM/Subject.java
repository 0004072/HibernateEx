package com.hsenid.ORM;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by hsenid on 2/15/17.
 *
 */
public class Subject implements Serializable{
    private String code, name;
    private Teacher teacher;

    public Subject() {

    }

    public Subject(String code, String name, Teacher teacher) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
