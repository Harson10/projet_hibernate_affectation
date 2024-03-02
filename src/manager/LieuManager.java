package manager;

import org.hibernate.Session;
import bean.Lieu;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import util.HibernateUtil;

/**
 *
 * @author ELOIC
 */

public class LieuManager {
     public  void ajouterLieu(String designation, String province){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Lieu l = new Lieu();
        l.setDesignation(designation);
        l.setProvince(province);
        
        session.save(l);
        session.getTransaction().commit();
    }
    
     public  void modifierLieu(int codelieu, String designation, String province){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Lieu l = new Lieu();
        l.setCodelieu(codelieu);
        l.setDesignation(designation);
        l.setProvince(province);
        
        session.update(l);
        session.getTransaction().commit();
    }
    
    public  void supprimerLieu(int codelieu){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Lieu l = (Lieu) session.load(Lieu.class, codelieu);
        session.delete(l);
        session.getTransaction().commit();
    }
    
    public List<Lieu> listeLieu() {
    
        Transaction trs = null;
        List<Lieu> lieux = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            lieux = session.createQuery("from Lieu").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(lieux);
        return lieux;
        
    }
    
    
    public List<Lieu> chercherCodeLieu(int codelieu) {
        
        String cl = Integer.toString(codelieu);
        Transaction trs = null;
        List<Lieu> lieux = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            lieux = session.createQuery("from Lieu where codelieu='"+cl+"'").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(lieux);
        return lieux;
        
    }
	
    
}
