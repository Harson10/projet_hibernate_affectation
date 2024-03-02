package bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ELOIC
 */

public class Affecter implements Serializable{
    private int codeemp;
    private int codelieu;
    private Date date;

    public Affecter() {}

    public Affecter(int codeemp, int codelieu, Date date) {
        super();
        this.codeemp = codeemp;
        this.codelieu = codelieu;
        this.date = date;
    }

    public int getCodeemp() {
        return codeemp;
    }

    public void setCodeemp(int codeemp) {
        this.codeemp = codeemp;
    }

    public int getCodelieu() {
        return codelieu;
    }

    public void setCodelieu(int codelieu) {
        this.codelieu = codelieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Affecter [codeemp=" + codeemp + ", codelieu=" + codelieu + ", date=" + date + "]";
    }
}
