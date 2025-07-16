/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.item;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class ItemBLO implements ItemBLI{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginStepPU");

    @Override
    public List<Item> searchItems(String searchName) {
        //Step 1 Create EntityManger
        EntityManager em = emf.createEntityManager();
        List<Item> result = null;
        //Step 2 Create jpql
        String jpql = "Select r "
                + "From Item r "
                + "Where r.name like :searchName";
        //Step 3 set query
        try{
            
        }finally{
            em.close();
        }
        //Step 4 result 
        return result;
    }

    @Override
    public String getNameByID(String searchName) {
        
    }

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
