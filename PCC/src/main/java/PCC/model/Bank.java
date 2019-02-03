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

    @Column(nullable = false)
    private String urlTransaction;

    @Column(nullable = false)
    private String urlResult;

    public Bank() {
    }

    public Bank(String nazivBanke, String kodBanke, String urlTransaction, String urlResult) {
        this.nazivBanke = nazivBanke;
        this.kodBanke = kodBanke;
        this.urlTransaction = urlTransaction;
        this.urlResult = urlResult;
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

    public String getUrlTransaction() {
        return urlTransaction;
    }

    public void setUrlTransaction(String urlTransaction) {
        this.urlTransaction = urlTransaction;
    }

    public String getUrlResult() {
        return urlResult;
    }

    public void setUrlResult(String urlResult) {
        this.urlResult = urlResult;
    }
}
