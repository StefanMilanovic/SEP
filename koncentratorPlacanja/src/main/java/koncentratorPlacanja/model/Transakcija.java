package koncentratorPlacanja.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import java.time.DateTimeException;
import java.util.Date;
import java.util.UUID;

@Entity
public class Transakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token = UUID.randomUUID().toString();

    @Column(nullable = false, precision=10, scale=2)
    private double kolicina;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Klijent klijent;

    @Column(nullable = false)
    private Date prodavacVremeTransakcije;



    public Transakcija() {}

    public Transakcija(double kolicina, Klijent klijent_id, Date prodavac_vreme_transakcije) {
        this.kolicina = kolicina;
        this.klijent = klijent_id;
        this.prodavacVremeTransakcije = prodavac_vreme_transakcije;
    }



    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public double getKolicina() {
        return kolicina;
    }

    public Klijent getKlijent_id() {
        return klijent;
    }

    public Date getProdavac_vreme_transakcije() {
        return prodavacVremeTransakcije;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public void setKlijent_id(Klijent klijent_id) {
        this.klijent = klijent_id;
    }

    public void setProdavac_vreme_transakcije(Date prodavac_vreme_transakcije) {
        this.prodavacVremeTransakcije = prodavac_vreme_transakcije;
    }
}
