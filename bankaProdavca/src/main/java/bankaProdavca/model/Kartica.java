package bankaProdavca.model;

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
    private int pan;

    @Column(nullable = false)
    private int pin;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private BankKlijent vlasnik;

    @Column()
    private String imeVlasnika;

    @Column(nullable = false)
    private Date datumIsteka;

    @Column()
    private double stanjeNaKartici;

    public Kartica(int pan, int pin, String imeVlasnika, Date datumIsteka, double stanjeNaKartici) {
        this.id = id;
        this.pan = pan;
        this.pin = pin;
        this.datumIsteka = datumIsteka;
        this.imeVlasnika = imeVlasnika;
        this.stanjeNaKartici = stanjeNaKartici;

    }

    public double getStanjeNaKartici() {
        return stanjeNaKartici;
    }

    public void setStanjeNaKartici(double stanjeNaKartici) {
        this.stanjeNaKartici = stanjeNaKartici;
    }

    public BankKlijent getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(BankKlijent vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getImeVlasnika() {
        return imeVlasnika;
    }

    public void setImeVlasnika(String imeVlasnika) {
        this.imeVlasnika = imeVlasnika;
    }

    public Kartica(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }
}
