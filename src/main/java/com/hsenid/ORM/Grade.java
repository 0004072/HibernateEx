package com.hsenid.ORM;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hsenid on 2/14/17.
 *
 */
public class Grade implements Serializable{
    private String id;
    private Teacher teacher;

    public Grade() {

    }

    public Grade(String id, Teacher teacher) {
        this.id = id;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
