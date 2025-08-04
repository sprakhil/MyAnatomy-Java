package com;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id of to delete: ");
        int uid = sc.nextInt();
        sc.nextLine();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student st = session.get(Student.class, uid);
        if (st != null) {
            session.delete(st);  

            tx.commit();
            System.out.println("Student record deleted successfully.");
        } else {
            System.out.println("Student with id " + uid + " not found.");
            tx.rollback();
        }

        session.close();
        sc.close();
    }
}
