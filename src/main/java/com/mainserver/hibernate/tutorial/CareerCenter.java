package com.mainserver.hibernate.tutorial;

import com.mainserver.hibernate.tutorial.entities.CompanyEntity;
import com.mainserver.hibernate.tutorial.entities.HrManagerEntity;
import com.mainserver.hibernate.tutorial.entities.JobAnnouncementEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class CareerCenter {

    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    private static Scanner scanner = new Scanner(System.in);
    private static HrManagerEntity loggedInHrManager = null;

    public static void main(String[] args) {
        loop:
        while (true) {
            if (loggedInHrManager == null) {
                System.out.println("(R) Register as an HR Manager");
                System.out.println("(L) Login");
                System.out.println("------------------------------");
            }

            System.out.println("(1) List all job openings");
            System.out.println("(2) Search job by criteria");
            System.out.println("(3) Open job description by id");

            if (loggedInHrManager != null) {
                System.out.println("------------------------------");
                System.out.println("(C) Create company");
                System.out.println("(J) Create job announcement");
            }

            System.out.println("(Q) quit");

            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "q":
                    break loop;
                case "1":
                    listAllJobOpenings();
                    break;
                case "2":
                    searchJobByCriteria();
                    break;
                case "3":
                    openJobDescriptionById();
                    break;
                case "r":
                    registerManager();
                    break;
                case "l":
                    login();
                    break;
                case "c":
                    createCompany();
                    break;
                case "j":
                    createJobAnnouncement();
                    break;
            }
        }
    }

    private static void listAllJobOpenings() {
        Session session = sessionFactory.openSession();
        TypedQuery<JobAnnouncementEntity> query = session.createQuery("from JobAnnouncementEntity", JobAnnouncementEntity.class);
        List<JobAnnouncementEntity> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    private static void searchJobByCriteria() {
        //TODO
    }

    private static void openJobDescriptionById() {
        //TODO
    }

    private static void registerManager() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Repeat password: ");
        String repeatPassword = scanner.nextLine();

        if (!password.equals(repeatPassword)) {
            System.out.println("masidhfuiashdufisahafhias");
            throw new Error();
        }

        Session session = sessionFactory.openSession();

        HrManagerEntity hrManagerEntity = new HrManagerEntity();

        hrManagerEntity.setEmail(email);
        hrManagerEntity.setFirstName(firstName);
        hrManagerEntity.setLastName(lastName);
        hrManagerEntity.setPassword(password);

        Transaction transaction = session.beginTransaction();
        session.save(hrManagerEntity);
        transaction.commit();

        session.flush();
        session.close();
    }

    private static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Session session = sessionFactory.openSession();
        TypedQuery<HrManagerEntity> query = session.createQuery("from HrManagerEntity h where h.email = :email and h.password = :password", HrManagerEntity.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        loggedInHrManager = query.getSingleResult();
    }

    private static void createCompany() {
        String email = scanner.nextLine();
        System.out.print("Email: ");

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setEmail(email);
//        companyEntity.setCompanyName(companyName);
//        companyEntity.setShortInfo(shortInfo);
//        companyEntity.setPhoneNumber(phoneNumber);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(companyEntity);
        loggedInHrManager.setCompanyEntity(companyEntity);
        session.save(loggedInHrManager);

        transaction.commit();

    }

    private static void createJobAnnouncement() {

    }

}