package PCC.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String nazivBanke;

    @Column(nullable = false, length = 5)
    private String kodBanke;

    public Bank() {
    }

    public Bank(String nazivBanke, String kodBanke) {
        this.nazivBanke = nazivBanke;
        this.kodBanke = kodBanke;
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

}
