package bankaKupca.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Kartica {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brojKartice;


    @Column(nullable = false)
    private String csc; // card security code

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private BankKlijent vlasnik;

    @Column()
    private String vlasnikKartice;

    @Column(nullable = false)
    private Date datumIsteka;

    @Column()
    private double stanjeNaKartici;

    public Kartica(){}

    public Kartica(String CSC, BankKlijent vlasnik, String vlasnikKartice, Date datumIsteka, double stanjeNaKartici, String brojKartice) {
        this.csc = CSC;
        this.vlasnik = vlasnik;
        this.vlasnikKartice = vlasnikKartice;
        this.datumIsteka = datumIsteka;
        this.stanjeNaKartici = stanjeNaKartici;
        this.brojKartice = brojKartice;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public BankKlijent getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(BankKlijent vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getVlasnikKartice() {
        return vlasnikKartice;
    }

    public void setVlasnikKartice(String vlasnikKartice) {
        this.vlasnikKartice = vlasnikKartice;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public double getStanjeNaKartici() {
        return stanjeNaKartici;
    }

    public void setStanjeNaKartici(double stanjeNaKartici) {
        this.stanjeNaKartici = stanjeNaKartici;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }
}
