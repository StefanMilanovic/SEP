package koncentratorPlacanja.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String nazivBanke;

    @Column(nullable = false, length = 5)
    private String kodBanke;

    @Column(nullable = false, length = 50)
    private String urlBanke;

    public Bank() {
    }

    public Bank(String nazivBanke, String kodBanke, String urlBanke) {
        this.nazivBanke = nazivBanke;
        this.kodBanke = kodBanke;
        this.urlBanke = urlBanke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivBanke() {
        return nazivBanke;
    }

    public void setNazivBanke(String nazivBanke) {
        this.nazivBanke = nazivBanke;
    }

    public String getKodBanke() {
        return kodBanke;
    }

    public void setKodBanke(String kodBanke) {
        this.kodBanke = kodBanke;
    }

    public String getUrlBanke() {
        return urlBanke;
    }

    public void setUrlBanke(String urlBanke) {
        this.urlBanke = urlBanke;
    }
}

