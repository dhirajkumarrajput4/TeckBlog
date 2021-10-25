/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.blog.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {
 
    public static boolean deleteFile(String path)
    {
        boolean f=false;
        
        try {
                
            File file=new File(path);
            f= file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return f;
    }
    
    public static boolean saveFile(InputStream is,String path)
    {
        boolean f=false;
        
        try {
            byte b[]=new byte[is.available()];
            is.read(b);
            FileOutputStream fos=new FileOutputStream(path);
            fos.write(b);
            fos.flush();
            fos.close();
            f=true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    
     public static String get50Word(String desc)
    {
        String[] str = desc.split(" ");
        
        if(str.length>50)
        {
            String res="";
            for(int i=0;i<50;i++)
            {
                res=res+str[i]+" ";
            }
            return (res+"...");
        }
        else
        {
            return (desc+"...");
        }
    }
    
}
