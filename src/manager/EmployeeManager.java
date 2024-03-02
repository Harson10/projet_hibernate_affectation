package manager;

import org.hibernate.Session;
import bean.Employee;
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

public class EmployeeManager {

    public  void ajouterEmployee(String nom, String prenom, String poste){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Employee e = new Employee();
        e.setNom(nom);
        e.setPrenom(prenom);
        e.setPoste(poste);
        
        session.save(e);
        session.getTransaction().commit();
    }
    
    public  void modifierEmployee(int codeemp, String nom, String prenom, String poste){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Employee e = new Employee();
        e.setCodeemp(codeemp);
        e.setNom(nom);
        e.setPrenom(prenom);
        e.setPoste(poste);
        session.update(e);
        session.getTransaction().commit();
    }
    
    public  void supprimerEmployee(int codeemp){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Employee e = (Employee) session.load(Employee.class, codeemp);
        session.delete(e);
        session.getTransaction().commit();
    }
    
    public List<Employee> listeEmployee() {
        
        Transaction trs = null;
        List<Employee> employees = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            employees = session.createQuery("from Employee").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(employees);
        return employees;
        
    }
    
    public List<Employee> chercherCodeEmp(int codeemp) {
        
        String ce = Integer.toString(codeemp);
        Transaction trs = null;
        List<Employee> employees = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            employees = session.createQuery("from Employee where codeemp='"+ce+"'").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(employees);
        return employees;
        
    }
	
    public List<Employee> chercherNomCodeEmp(Object var) {
        
        Transaction trs = null;
        List<Employee> employees = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            trs = session.beginTransaction();
            employees = session.createQuery("from Employee where codeemp='"+var+"' or nom like '%"+var+"%' or prenom like '%"+var+"%'").list();
            trs.commit();
        } catch (HibernateException e) {
            if (trs != null) {
                trs.rollback();
            }
        }
        System.out.println(employees);
        return employees;
        
    }
	
}
