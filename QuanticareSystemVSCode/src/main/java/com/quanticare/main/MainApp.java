/*package com.quanticare.main;

import com.quanticare.entity.Patient;
import com.quanticare.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Patient p = new Patient();
            p.setName("Sushant");
            p.setAge(30);
            p.setDisease("Flu");

            em.persist(p);
            em.getTransaction().commit();

            System.out.println("Patient saved successfully!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();  
        }
    }
}*/
package com.quanticare.main;

import com.quanticare.entity.Patient;
import com.quanticare.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        try {
            boolean running = true;

            while (running) {
                System.out.println("\n--- Quanticare Patient System --- ");
                System.out.println("1. Create Patient");
                System.out.println("2. Read All Patients");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1: // CREATE
                        em.getTransaction().begin();
                        Patient newPatient = new Patient();

                        System.out.print("Enter patient name: ");
                        newPatient.setName(sc.nextLine());

                        System.out.print("Enter patient age: ");
                        newPatient.setAge(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter disease: ");
                        newPatient.setDisease(sc.nextLine());

                        em.persist(newPatient);
                        em.getTransaction().commit();
                        System.out.println("Patient created successfully!");
                        break;

                    case 2: // READ
                        Query query = em.createQuery("SELECT p FROM Patient p", Patient.class);
                        List<Patient> patients = query.getResultList();

                        if (patients.isEmpty()) {
                            System.out.println("No patients found.");
                        } else {
                            System.out.println("\n--- Patient List ---");
                            for (Patient p : patients) {
                                System.out.println("ID: " + p.getId() + ", Name: " + p.getName()
                                        + ", Age: " + p.getAge() + ", Disease: " + p.getDisease());
                            }
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter patient ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        Patient updatePatient = em.find(Patient.class, updateId);
                        if (updatePatient == null) {
                            System.out.println("Patient not found.");
                        } else {
                            System.out.print("Enter new name (" + updatePatient.getName() + "): ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new age (" + updatePatient.getAge() + "): ");
                            int newAge = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new disease (" + updatePatient.getDisease() + "): ");
                            String newDisease = sc.nextLine();

                            em.getTransaction().begin();
                            updatePatient.setName(newName);
                            updatePatient.setAge(newAge);
                            updatePatient.setDisease(newDisease);
                            em.getTransaction().commit();

                            System.out.println("Patient updated successfully!");
                        }
                        break;

                    case 4: // DELETE
                        System.out.print("Enter patient ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        Patient deletePatient = em.find(Patient.class, deleteId);
                        if (deletePatient == null) {
                            System.out.println("Patient not found.");
                        } else {
                            em.getTransaction().begin();
                            em.remove(deletePatient);
                            em.getTransaction().commit();
                            System.out.println("Patient deleted successfully.");
                        }
                        break;

                    case 5:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
            sc.close();
            System.out.println("Application exited.");
        }
    }
}

