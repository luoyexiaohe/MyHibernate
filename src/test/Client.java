package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import single.Book;  
  
public class Client {  
    public static void main(String[] args) {  
        //��ȡ�����ļ�  
        Configuration cfg = new Configuration().configure();  
        
        cfg.addClass(Book.class);
          
        SessionFactory factory = cfg.buildSessionFactory();  
          
        Session session = null;  
        try{  
            session = factory.openSession();  
            //��������  
            session.beginTransaction();  
              
            Book book = new Book();
            book.setBookid("110");
            book.setBookname("������");
              
            session.save(book);  
            //�ύ����  
            session.getTransaction().commit();  
              
        }catch(Exception e){  
            e.printStackTrace();  
            //�ع�����  
            session.getTransaction().rollback();  
        }finally{  
            if(session != null){  
                if(session.isOpen()){  
                    //�ر�session  
                    session.close();  
                }  
            }  
        }  
    }  
}  