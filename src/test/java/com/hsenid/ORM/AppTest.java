package com.hsenid.ORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest{
    private Student student;
    private Set<Subject> subjects;
    private Teacher teacher;
    private Grade grade;

    private Configuration cfg;
    private SessionFactory sf;
    private Session session;
    private Transaction t;

    @Before
    public void init(){
        teacher = new Teacher("001", "test teacher");
        grade = new Grade("11-A", teacher);
        subjects = new HashSet<>();

        for(int i = 0; i < 1; i++){
            subjects.add(new Subject(String.format("%d",i), "test", teacher));
        }

        student = new Student("S01", "test student", grade, subjects);

        cfg = new Configuration();
        cfg.configure("test.hibernate.cfg.xml");

        sf = cfg.buildSessionFactory();

        session = sf.openSession();

        t = session.beginTransaction();
    }

    @Test
    public void testInsertStudent(){
        try {
            session.persist(student);
        }
        catch(Exception ex){
            assertTrue("Failed to persist the student object!", false);
            return;
        }

        String hql = "from Student std where std.id like 'S01'";
        Query query = session.createQuery(hql);
        List<Student> res = query.list();

        if(res.size() != 1) {
            assertTrue("Invalid query!", false);
            return;
        }

        if(!res.get(0).equals(student)){
            assertTrue("objects mismatch!", false);
            return;
        }

        System.out.println("Test completed!");
    }

    @After
    public void destroy(){
        t.commit();
        session.close();
        sf.close();
    }
}
