package com.tech.blog.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory factory;
    
    public static SessionFactory getFactory()
    {
        try {
            
            if(factory==null)
            {
                Configuration config=new Configuration().configure("hibernate.cfg.xml");
                SessionFactory fs=config.buildSessionFactory();
                factory=fs;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(factory);
        return factory;
    }
    
}
