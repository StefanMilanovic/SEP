package bankaProdavca.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Kartica {
//    PAN: string;
//    PIN: string;
//    vlasnikKartice: string;
//    datumIsteka: Date;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brojKartice;

    @Column(nullable = false)
    private int PAN;

    @Column(nullable = false)
    private int CSC; // card security code

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

    public Kartica(int PAN, int CSC, BankKlijent vlasnik, String vlasnikKartice, Date datumIsteka, double stanjeNaKartici, String brojKartice) {
        this.PAN = PAN;
        this.CSC = CSC;
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

    public int getPAN() {
        return PAN;
    }

    public void setPAN(int PAN) {
        this.PAN = PAN;
    }

    public int getCSC() {
        return CSC;
    }

    public void setCSC(int CSC) {
        this.CSC = CSC;
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
