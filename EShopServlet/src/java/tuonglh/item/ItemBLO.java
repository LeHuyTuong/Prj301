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
import javax.persistence.Query;

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
                + "Where r.name like :searchValue";
        
        try{
            //Step 3 set query
            Query query = em.createQuery(jpql);
            query.setParameter("searchValue", "%" + searchName + "%");
            //Step 4 result 
            result = query.getResultList();
        }finally{
            em.close();
        }
        
        return result;
    }
//
//    @Override
//    public String getNameByID(String searchName) {
//        //Step 1 Create EntityManger
//        EntityManager em = emf.createEntityManager();
//        String result = null;
//        //Step 2 Create jpql
//        String jpql = "Select r "
//                + "From Item r "
//                + "Where r.name like :searchName";
//        
//        try{
//            //Step 3 set query
//            Query query = em.createQuery(jpql);
//            query.setParameter("name", "%" + searchName + "%");
//            //Step 4 result 
//            result = query.getSingleResult();
//        }finally{
//            em.close();
//        }
//        
//        return result;
//    }

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

    @Override
    public Item getNameByID(String searchName) {
        //Step 1 Create EntityManger
        EntityManager em = emf.createEntityManager();
        Item result = null;
        //Step 2 Create jpql
        String jpql = "Select r "
                + "From Item r "
                + "Where r.name like :searchName";
        
        try{
            //Step 3 set query
            Query query = em.createQuery(jpql);
            query.setParameter("name", "%" + searchName + "%");
            //Step 4 result 
            result = (Item) query.getSingleResult();
        }finally{
            em.close();
        }
        
        return result;
    }

    @Override
    public boolean addNewItem(Item item) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try{
            Item i = em.find(Item.class, item.getItemID());
            if(i == null){
                em.getTransaction().begin();
                em.persist(item);
                em.getTransaction().commit();
            }
        }finally{
            em.close();
        }
        return result;
    }
}
