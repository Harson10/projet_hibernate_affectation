package manager;

import org.hibernate.Session;
import bean.Affecter;
import java.io.Serializable;
import java.util.Date;
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

public class AffecterManager {

    public void ajouterAffectation(int codeemp, int codelieu, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
//        Affecter affectation = new Affecter(codeemp, codelieu, date);

        Affecter a = new Affecter();
        a.setCodeemp(codeemp);
        a.setCodelieu(codelieu);
        a.setDate(date);
        
        session.save(a);
        session.getTransaction().commit();
    }

    public void modifierAffectation(int codeemp, int codelieu, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Affecter a = new Affecter();
        a.setCodeemp(codeemp);
        a.setCodelieu(codelieu);
        a.setDate(date);
        
        session.update(a);
        session.getTransaction().commit();
    }

    public void supprimerAffectation(int codeemp, int codelieu, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Affecter affectation = (Affecter) session.get(Affecter.class, (Serializable) new Affecter(codeemp, codelieu, date));
        session.delete(affectation);
        session.getTransaction().commit();
    }
    
     
    public List<Affecter> listeAffectation() {
    
        Transaction trs = null;
        List<Affecter> affectations = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            affectations = session.createQuery("from Affecter").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(affectations);
        return affectations;
        
    }
    
    
    public List<Affecter> chercherAff(int codeemp, int codelieu) {
//    public List<Affecter> chercherAff(int codeemp, int codelieu, Date date) {
          
        
        String ce = Integer.toString(codeemp);
        String cl = Integer.toString(codelieu);
//        Date dt = date;
//        String str_date = dt.toString();
        Transaction trs = null;
        List<Affecter> affectations = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            affectations = session.createQuery("from Affecter where codeemp="+ce+" and codelieu="+cl+"").list();
//            affectations = session.createQuery("from Affecter where codeemp="+ce+" and codelieu="+cl+" and date="+dt+"").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(affectations);
        return affectations;
        
    }
	
}
