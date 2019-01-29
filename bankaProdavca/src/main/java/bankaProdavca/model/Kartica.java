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
    private int PAN;

    @Column(nullable = false)
    private int PIN;

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

    public Kartica(int PAN, int PIN, BankKlijent vlasnik, String vlasnikKartice, Date datumIsteka, double stanjeNaKartici) {
        this.PAN = PAN;
        this.PIN = PIN;
        this.vlasnik = vlasnik;
        this.vlasnikKartice = vlasnikKartice;
        this.datumIsteka = datumIsteka;
        this.stanjeNaKartici = stanjeNaKartici;
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

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
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
}
