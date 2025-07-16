/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

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
public class SigninBLO implements SigninBLI{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginStepPU");

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
    public Signin checkLogin(String phoneNumber, String password) {
        //Step 1 add Entity Manage
        EntityManager em = emf.createEntityManager();
        Signin result = null;
        //Step 2 create Query 
        String jpql = "Select r "
                + "From Signin r "
                + "Where r.phoneNumber = :phoneNumber "
                + "And r.password = :password ";
        try{
            //Step 3 createQuery in Entity Manager 
            Query query = em.createQuery(jpql);
            query.setParameter("phoneNumber", phoneNumber);
            query.setParameter("password", password);
            
            
            //Step 4 result 
            result = (Signin) query.getSingleResult(); // vi chi co 1 pk ung voi 1 object nen chi in ra 1 dong duy nhat
                                                        // va phai ep kieu
        }finally{
            em.close();
        }
        return result;
    }

    @Override
    public List<Signin> searchLastName(String searchValue) {
        //Step 1 create entity manger
        EntityManager em = emf.createEntityManager();
        List<Signin> result = null;
        //step 2 create jpql
        String jpql = "Select r "
                + "From Signin r "
                + "Where r.name like :searchValue";
        try{
            //step 3 create query to set param
            Query query = em.createQuery(jpql);
            query.setParameter("searchValue", "%" + searchValue +"%");
        //step 4 result
            result = query.getResultList(); // in ra 1 list result 
        }finally{
            em.close();
        }
        
        return result;
    }

    @Override
    public boolean deleteValue(String phoneNumber) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try{
            // nhung ham delete update create thi su dung sql transtration
            //gio muon giet con ga thi phai di tim con ga 
            
            Signin sign = em.find(Signin.class, phoneNumber);
            
            // neu co con ga thi xu no 
            em.getTransaction().begin();
            em.remove(sign);
            em.getTransaction().commit();
            result = true;
        }finally{
            em.close();
        }
        return result ;
    }

    @Override
    public boolean updateAccount(String phone, String password, boolean role) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try{
            // tim ga 
            Signin sign = em.find(Signin.class, phone);
            // di nang cap con ga neu co 
            if(sign != null){
                sign.setPassword(password);
                sign.setRole(role);
                em.getTransaction().begin();
                em.merge(sign);
                em.getTransaction().commit();
                result = true;
            }
        }finally{
            em.close();
        }
        return result;
    }

    @Override
    public boolean createAccount(Signin accounts) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try{
            // tim ga 
            Signin sign = em.find(Signin.class, accounts.getPhoneNumber());
            // di them con ga neu ko co
            if(sign == null){
                em.getTransaction().begin();
                em.persist(accounts);
                em.getTransaction().commit();
                result = true;
            }
        }finally{
            em.close();
        }
        return result;
    }
    
    
    
}
