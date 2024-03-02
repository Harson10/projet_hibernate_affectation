package bean;

import java.util.Comparator;

/**
 *
 * @author ELOIC
 */

public class Employee {
    private int codeemp ;
    private String nom;
    private String prenom;
    private String poste;
    

    public Employee() {}
    
    public Employee(int codeemp, String nom, String prenom, String poste) {
        super();
        this.codeemp = codeemp;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }
    
    public int getCodeemp() {
        return this.codeemp;
    }
    
    public void setCodeemp(int codeemp) {
        this.codeemp = codeemp;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    } 
    
    
    public String getPrenom(){
        return prenom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    } 
        
    public String getPoste(){
        return poste;
    }
    
    public void setPoste(String poste){
        this.poste = poste;
    } 
    
    @Override
    public String toString() {
        return "Employee [codeemp =" + codeemp + ", nom =" + nom + ", prenom =" + prenom + ", poste =" + poste + "]";
    }

    public void sort(Comparator<Employee> comparingInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
