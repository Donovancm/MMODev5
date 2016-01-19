/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmodev5;

import View.MainScreen;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Donovan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        MainScreen mainscreen = new MainScreen();
        mainscreen.setVisible(true);
        mainscreen.setLocationRelativeTo(null);
        
    }
    public static void persist(Object object) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MMODev5PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    
}
