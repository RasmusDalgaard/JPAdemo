/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademo.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        //Persons
        Person p1 = new Person("Bob", 1963);
        Person p2 = new Person("Tarzan", 1970);
        Person p3 = new Person("Batman", 1960);
        Person p4 = new Person("Gertrud", 1940);
        Person p5 = new Person("Hans", 1980);
        Person p6 = new Person("Hannibal", 1977);
        Person p7 = new Person("Magrethe", 1950);
        Person p8 = new Person("Mogens", 1985);
        Person p9 = new Person("Ludvig", 2000);
        Person p10 = new Person("Karen", 1959);
        //Addresses
        Address a1 = new Address("Store Torv 1", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");
        Address a3 = new Address("Gotham Street", 4567, "Gotham");
        Address a4 = new Address("Frem 21", 2800, "Kongens Lyngby");
        Address a5 = new Address("Bagsværdvej 55", 2880, "Bagsværd");
        Address a6 = new Address("Søborg Hovedgade 3", 2860, "Søborg");
        Address a7 = new Address("Husumvej 77", 2700, "Brønshøj");
        Address a8 = new Address("Birkevej 14", 2820, "Gentofte");
        Address a9 = new Address("Nørregade 81", 1000, "København K");
        Address a10 = new Address("Hjortkærsvej 92", 2800, "Kongens Lyngby");
        //Fees
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        Fee f3 = new Fee(300);
        Fee f4 = new Fee(400);
        Fee f5 = new Fee(500);
        Fee f6 = new Fee(600);
        Fee f7 = new Fee(700);
        Fee f8 = new Fee(800);
        Fee f9 = new Fee(900);
        Fee f10 = new Fee(1000);
        //Swim styles
        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Butterfly");
        SwimStyle s3 = new SwimStyle("Breast stroke");
        //-----------------------------------------

        //Set addresses
        p1.setAddress(a1);
        p2.setAddress(a2);
        p3.setAddress(a3);
        p4.setAddress(a4);
        p5.setAddress(a5);
        p6.setAddress(a6);
        p7.setAddress(a7);
        p8.setAddress(a8);
        p9.setAddress(a9);
        p10.setAddress(a10);
        //Add fees
        p1.addFee(f1);
        p2.addFee(f2);
        p2.addFee(f3);
        p3.addFee(f6);
        p4.addFee(f5);
        p5.addFee(f7);
        p6.addFee(f10);
        p7.addFee(f1);
        p7.addFee(f4);
        p8.addFee(f9);
        p9.addFee(f10);
        p9.addFee(f9);
        p10.addFee(f3);

        //Add swim styles
        p1.addSwimStyle(s1);
        p1.addSwimStyle(s2);
        p1.addSwimStyle(s3);
        p2.addSwimStyle(s3);
        p3.addSwimStyle(s1);
        p3.addSwimStyle(s3);
        p4.addSwimStyle(s1);
        p5.addSwimStyle(s1);
        p6.addSwimStyle(s3);
        p6.addSwimStyle(s2);
        p7.addSwimStyle(s2);
        p8.addSwimStyle(s1);
        p9.addSwimStyle(s2);
        p10.addSwimStyle(s1);
        p10.addSwimStyle(s2);
        p10.addSwimStyle(s3);

        //------------------------------------------
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);
        em.persist(p8);
        em.persist(p9);
        em.persist(p10);
        em.getTransaction().commit();

        System.out.println("p1: " + p1.getId() + ", " + p1.getName());
        System.out.println("Bobs gade: " + p1.getAddress().getStreet());
        System.out.println("p2: " + p2.getId() + ", " + p2.getName());
        System.out.println("Tarzans gade: " + p2.getAddress().getStreet());

        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());

        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());

    }
}
