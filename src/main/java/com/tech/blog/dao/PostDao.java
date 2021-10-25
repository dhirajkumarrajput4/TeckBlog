
package com.tech.blog.dao;

import com.tech.blog.entities.Post;
import com.tech.blog.entities.PostCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PostDao {
    SessionFactory factory;
    
    public PostDao(SessionFactory factory)
    {
        this.factory=factory;
    }
    
    public PostCategory getCategoryById(int catid)
    {
        PostCategory pc=null;
        try {
            Session session=factory.openSession();
            Transaction tx=session.beginTransaction();
            pc=session.get(PostCategory.class, catid);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pc;
    }
    public ArrayList<PostCategory> getAllCategory()
    {
        ArrayList<PostCategory> list=null;
        
        try {
            String query="from PostCategory";
            
            Session session=factory.openSession();
            Transaction tx=session.beginTransaction();
            Query q=session.createQuery(query);
            
            list=(ArrayList<PostCategory>)q.list();
            
            tx.commit();
            session.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return list;
    }
    
    
    
    public boolean savePost(Post p)
    {
        System.out.println("Save post method called of Post dao class++++++++++++++");
        boolean f=false;
        try {
                Session session=factory.openSession();
                Transaction tx=session.beginTransaction();
                
                session.save(p);
                
                tx.commit();
                session.close();
                
                f=true;
                
                System.out.println("product saved :+++++++"+f);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return f;
    }

    
    //get all post 
    public List<Post> getAllPost()
    {
        
        List<Post> list=null;
        //fetch all post
        try {
            String query="from Post";
            Session session=factory.openSession();
            Transaction tx=session.beginTransaction();
            Query q=session.createQuery(query);
            list=(List<Post>)q.list();
            tx.commit();
            session.close();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Post> getPostById(PostCategory catId)            
    {
         List<Post> list=null;
         try {
            
        //fetch all post by id
        
     
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Query q=session.createQuery("from Post p where p.category_Id=:cid");
        q.setParameter("cid", catId);
        list=(List<Post>)q.list();
        
        tx.commit();
        session.close();
        
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return list;
    }
    
    
}
