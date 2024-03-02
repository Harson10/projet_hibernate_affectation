package bean;

/**
 *
 * @author ELOIC
 */

public class Lieu {
    private int codelieu;
    private String designation;
    private String province;
    
    public Lieu() {}
    
    public Lieu(int codelieu, String designation, String province) {
        super();
        this.codelieu = codelieu;
        this.designation = designation;
        this.province = province;
    }
    
    public int getCodelieu() {
        return this.codelieu;
    }
    
    public void setCodelieu(int codelieu) {
        this.codelieu = codelieu;
    }
    
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Override
    public String toString() {
        return "Lieu [codelieu =" + codelieu + ", designation =" + designation + ", province =" + province + "]";
    }
}
