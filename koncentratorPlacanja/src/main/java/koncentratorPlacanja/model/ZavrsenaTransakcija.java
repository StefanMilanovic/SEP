package koncentratorPlacanja.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ZavrsenaTransakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false, precision=10, scale=2)
    private double kolicina;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Klijent klijent;


    @Column(nullable = false)
    private Date prodavacVremeTransakcije;

    @Column(nullable = false)
    private String bankRacunProdavac;

    @Column(nullable = false)
    private String rezultat;

    public ZavrsenaTransakcija(){}

    public ZavrsenaTransakcija(String token, double kolicina, Klijent klijent,
                               String bankRacunProdavac, String rezultat) {
        this.token = token;
        this.kolicina = kolicina;
        this.klijent = klijent;
        this.prodavacVremeTransakcije = new Date();
        this.bankRacunProdavac = bankRacunProdavac;
        this.rezultat = rezultat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Date getProdavacVremeTransakcije() {
        return prodavacVremeTransakcije;
    }

    public void setProdavacVremeTransakcije(Date prodavacVremeTransakcije) {
        this.prodavacVremeTransakcije = prodavacVremeTransakcije;
    }

    public String getBankRacunProdavac() {
        return bankRacunProdavac;
    }

    public void setBankRacunProdavac(String bankRacunProdavac) {
        this.bankRacunProdavac = bankRacunProdavac;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
}
