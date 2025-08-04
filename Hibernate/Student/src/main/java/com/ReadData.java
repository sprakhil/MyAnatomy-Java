package com;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadData {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        try {
            List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();

            System.out.println("List of Students:");
            for (Student st : students) {
                System.out.println("ID: " + st.getUid() 
                    + ", Name: " + st.getName() 
                    + ", City: " + st.getCity()
                    + ", Pin: " + st.getPin());
            }
        } finally {
            session.close();
            factory.close();
        }
    }
}
