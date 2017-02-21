package com.hsenid.ORM;

import java.io.Serializable;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Student implements Serializable{
    private String id;
    private String name;
    private Grade grade;
    //private Address address;
    private Set<Subject> subjects;

    public Student() {

    }

    public Student(String id, String name, Grade grade, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.subjects = subjects;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
