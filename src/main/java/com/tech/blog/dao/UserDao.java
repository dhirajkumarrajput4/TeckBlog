
package com.tech.blog.dao;

import com.tech.blog.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
    private SessionFactory factory;
    
    public UserDao(SessionFactory sessionfactory)
    {
        this.factory=sessionfactory;
    }
    
   public boolean saveUser(User user)
   {
       System.out.println("User dao SaveUser method called");
       boolean f=false;
       try {
           Session session=this.factory.openSession();
           Transaction tx = session.beginTransaction();
           
           session.save(user); //save user
           tx.commit();
           session.close();
           f=true;
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       
       System.out.println(f);
       return f;
   }
           
    public  User getUserByEmailAndPassword(String email,String password)
    {
        User user=null;
        try {
            
            String query="from User where userEmail=:e and userPassword=:p";
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p",password);
            
            user=(User)q.uniqueResult();
            
            System.out.println(user);
            
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("User==="+user);
        return user;
    }
    
    public boolean updateUser(User user)
    {
        System.out.println("Update user++");
        boolean f=false;
        if(user.getProfilePic().isEmpty())
        {
        try {
            String query="update User set userName=:un,userEmail=:ue, userPassword=:up,userAbout=:ua where userId=:ui";
            Session session=this.factory.openSession();
            Transaction tx=session.beginTransaction();
            Query q=session.createQuery(query);
            System.out.println("query create");
            q.setParameter("un",user.getUserName());
            q.setParameter("ue",user.getUserEmail());
            q.setParameter("up",user.getUserPassword());
            q.setParameter("ua",user.getUserAbout());
//            q.setParameter("pp",user.getProfilePic());
            q.setParameter("ui",user.getUserId());
            System.out.println("before execute and update data");
           
            int result=q.executeUpdate();
            tx.commit();
            session.close();
            System.out.println("result:  "+result);
            
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        else
        {
             try {
            String query="update User set userName=:un,userEmail=:ue, userPassword=:up,userAbout=:ua,profilePic=:pp where userId=:ui";
            Session session=this.factory.openSession();
            Transaction tx=session.beginTransaction();
            Query q=session.createQuery(query);
            System.out.println("query create");
            q.setParameter("un",user.getUserName());
            q.setParameter("ue",user.getUserEmail());
            q.setParameter("up",user.getUserPassword());
            q.setParameter("ua",user.getUserAbout());
            q.setParameter("pp",user.getProfilePic());
            q.setParameter("ui",user.getUserId());
            System.out.println("before execute and update data");
           
            int result=q.executeUpdate();
            tx.commit();
            session.close();
            System.out.println("result:  "+result);
            
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return f;
    }
}


