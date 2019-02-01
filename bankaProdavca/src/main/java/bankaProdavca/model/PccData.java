package bankaProdavca.model;

import java.util.Date;

public class PccData {

    private String aqquirerOrderId;
    private Date aqquirerTimestamp;
    private String brojKartice;
    private String csc;
    private double stanjeNaKartici;
    private Date datumIsteka;

    public PccData(String aqquirerOrderId, Date aqquirerTimestamp, String brojKartice, String csc, double stanjeNaKartici, Date datumIsteka) {
        this.aqquirerOrderId = aqquirerOrderId;
        this.aqquirerTimestamp = aqquirerTimestamp;
        this.brojKartice = brojKartice;
        this.csc = csc;
        this.stanjeNaKartici = stanjeNaKartici;
        this.datumIsteka = datumIsteka;
    }

    public String getAqquirerOrderId() {
        return aqquirerOrderId;
    }

    public void setAqquirerOrderId(String aqquirerOrderId) {
        this.aqquirerOrderId = aqquirerOrderId;
    }

    public Date getAqquirerTimestamp() {
        return aqquirerTimestamp;
    }

    public void setAqquirerTimestamp(Date aqquirerTimestamp) {
        this.aqquirerTimestamp = aqquirerTimestamp;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public double getStanjeNaKartici() {
        return stanjeNaKartici;
    }

    public void setStanjeNaKartici(double stanjeNaKartici) {
        this.stanjeNaKartici = stanjeNaKartici;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }
}
