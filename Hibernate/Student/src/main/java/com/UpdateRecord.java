package com;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateRecord {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id to update: ");
        int uid = sc.nextInt();
        sc.nextLine();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student st = session.get(Student.class, uid);
        if (st != null) {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new city: ");
            String city = sc.nextLine();

            System.out.print("Enter new pin: ");
            int pin = sc.nextInt();
            sc.nextLine();

            st.setName(name);
            st.setCity(city);
            st.setPin(pin);

            session.merge(st);  

            tx.commit();
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record with id " + uid + " not found.");
            tx.rollback();
        }

        session.close();
        sc.close();
    }
}
