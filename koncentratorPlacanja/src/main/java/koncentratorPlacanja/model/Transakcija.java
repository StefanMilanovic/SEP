package koncentratorPlacanja.model;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.UUID;

@Entity
public class Transakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token = UUID.randomUUID().toString();

    @Column(nullable = false)
    private double kolicina;

    @Column(nullable = false)
    private String prodavac;

    @Column(nullable = false)
    private String lozinkaProdavca;

    @Column(nullable = false)
    private int prodavacTransakcijaId;

    @Column(nullable = false)
    private Long prodavacVremeTransakcije;

    @Column(nullable = false)
    private String success_url;


    @Column(nullable = false)
    private String faild_url;

    @Column(nullable = false)
    private String error_url;

    public Transakcija() {}


    public Transakcija(String token, double kolicina, String prodavac, String lozinkaProdavca, int prodavacTransakcijaId, long prodavacVremeTransakcije, String success_url, String faild_url, String error_url) {
        this.token = token;
        this.kolicina = kolicina;
        this.prodavac = prodavac;
        this.lozinkaProdavca = lozinkaProdavca;
        this.prodavacTransakcijaId = prodavacTransakcijaId;
        this.prodavacVremeTransakcije = prodavacVremeTransakcije;
        this.success_url = success_url;
        this.faild_url = faild_url;
        this.error_url = error_url;
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

    public String getProdavac() {
        return prodavac;
    }

    public void setProdavac(String prodavac) {
        this.prodavac = prodavac;
    }

    public String getLozinkaProdavca() {
        return lozinkaProdavca;
    }

    public void setLozinkaProdavca(String lozinkaProdavca) {
        this.lozinkaProdavca = lozinkaProdavca;
    }

    public int getProdavacTransakcijaId() {
        return prodavacTransakcijaId;
    }

    public void setProdavacTransakcijaId(int prodavacTransakcijaId) {
        this.prodavacTransakcijaId = prodavacTransakcijaId;
    }

    public long getProdavacVremeTransakcije() {
        return prodavacVremeTransakcije;
    }

    public void setProdavacVremeTransakcije(long prodavacVremeTransakcije) {
        this.prodavacVremeTransakcije = prodavacVremeTransakcije;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public void setSuccess_url(String success_url) {
        this.success_url = success_url;
    }

    public String getFaild_url() {
        return faild_url;
    }

    public void setFaild_url(String faild_url) {
        this.faild_url = faild_url;
    }

    public String getError_url() {
        return error_url;
    }

    public void setError_url(String error_url) {
        this.error_url = error_url;
    }
}
