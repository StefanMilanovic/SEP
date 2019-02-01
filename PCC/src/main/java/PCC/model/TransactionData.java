package PCC.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String aqquirerOrderId;

    @Column(nullable = false)
    private Date aqquirerTimestamp;

    @Column(nullable = false)
    private String brojKartice;

    @Column(nullable = false)
    private String csc; // card security code

    @Column()
    private double stanjeNaKartici;

    @Column(nullable = false)
    private Date datumIsteka;

    public TransactionData(){}

    public TransactionData(Long id, String aqquirerOrderId, Date aqquirerTimestamp, String brojKartice, String csc, double stanjeNaKartici, Date datumIsteka) {
        this.id = id;
        this.aqquirerOrderId = aqquirerOrderId;
        this.aqquirerTimestamp = aqquirerTimestamp;
        this.brojKartice = brojKartice;
        this.csc = csc;
        this.stanjeNaKartici = stanjeNaKartici;
        this.datumIsteka = datumIsteka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
