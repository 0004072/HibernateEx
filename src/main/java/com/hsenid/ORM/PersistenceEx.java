package com.hsenid.ORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by hsenid on 2/14/17.
 *
 */
public class PersistenceEx {
    public static String randomString(){
        SecureRandom sr = new SecureRandom();
        return new BigInteger(32, sr).toString(32);
    }

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        //Teacher teacher1 = new Teacher("762345121V", "Amal Ranasinghe");
        //Teacher teacher2 = new Teacher("762312232V", "Lakshman Karunarathne");
        Teacher[] teachers = {
                new Teacher("762345121V", "Amal Ranasinghe"),
                new Teacher("762312494V", "Lakshman Karunarathne"),
                new Teacher("762312265V", "Kumari Chandrika"),
                new Teacher("762312456V", "Kolitha Ranjana"),
                new Teacher("762312274V", "Ranjith Pushpakumara"),
                new Teacher("762312232V", "Kamal Samarakoon"),
                new Teacher("762312211V", "Manoj Pathiraja"),
                new Teacher("762312243V", "Nishshanka Weerasekara"),
        };

        ArrayList<Integer> tchrInd = new ArrayList<>();
        for(int i = 0; i < 8; i++)
            tchrInd.add(i);

        for(Teacher tch : teachers){
            session.persist(tch);
        }

        Subject subChem = new Subject("SC0001", "chemistry", teachers[0]);
        Subject subBio = new Subject("SC0002", "biology", teachers[1]);
        Subject subCm = new Subject("SC0003", "combined maths", teachers[0]);
        Subject subAgri = new Subject("SC0004", "agriculture", teachers[1]);
        Subject subPhy = new Subject("SC0005", "physics", teachers[3]);

        Set<Subject> subjects = new HashSet<>();
        subjects.add(subChem);
        subjects.add(subBio);
        subjects.add(subCm);
        subjects.add(subAgri);
        subjects.add(subPhy);

        Grade grd = null;
        char arrCh[] = {'A', 'B', 'C', 'D'};
        int arrI[] = {10, 11};
        int a = 0;
        for(int i : arrI){
            int b = 0;
            for(char ch : arrCh){
                grd = new Grade();
                grd.setId(String.format("%d-%s", i, ch));
                grd.setTeacher(teachers[a + b]);
                session.persist(grd);
                Student std = null;
                for(int j = 1; j <= 9; j++){
                    std = new Student();
                    DecimalFormat df = new DecimalFormat("0000");
                    std.setId(String.format("91366%sV", df.format(j * i * ch)));
                    std.setName(randomString());
                    std.setGrade(grd);
                    std.setSubjects(subjects);
                    session.persist(std);
                }
                b++;
            }
            a += 4;
        }

        t.commit();
        session.close();
        sf.close();
    }
}
