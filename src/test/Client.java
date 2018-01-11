package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import single.Book;  
  
public class Client {  
    public static void main(String[] args) {  
        //读取配置文件  
        Configuration cfg = new Configuration().configure();  
        
        cfg.addClass(Book.class);
          
        SessionFactory factory = cfg.buildSessionFactory();  
          
        Session session = null;  
        try{  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
              
            Book book = new Book();
            book.setBookid("110");
            book.setBookname("钢铁侠");
              
            session.save(book);  
            //提交事务  
            session.getTransaction().commit();  
              
        }catch(Exception e){  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally{  
            if(session != null){  
                if(session.isOpen()){  
                    //关闭session  
                    session.close();  
                }  
            }  
        }  
    }  
}  