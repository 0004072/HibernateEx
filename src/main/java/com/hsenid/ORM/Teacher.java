package com.hsenid.ORM;

import java.io.Serializable;

/**
 * Created by hsenid on 2/14/17.
 *
 */
public class Teacher implements Serializable{
    private String id, name;

    public Teacher() {

    }

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
