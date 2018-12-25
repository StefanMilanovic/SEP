package koncentratorPlacanja.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, length = 30)
//    private String id_prodavca;
//
//    @Column(nullable = false, length = 100)
//    private String lozinka_prodavca;

    @Column(nullable = false,  length = 30)
    private String prodavacBankId;

    @Column(nullable = false, length = 100)
    private String prodavacBankLozinka;

    @Column(nullable = false, length = 200)
    private String successUrl;

    @Column(nullable = false, length = 200)
    private String failedUrl;

    @Column(nullable = false, length = 200)
    private String errorUrl;

    @OneToMany(mappedBy = "klijent", cascade = CascadeType.ALL)
    private List<Transakcija> transakcije = new ArrayList<Transakcija>();

    public Klijent(Long id, String prodavac_bank_id, String prodavac_bank_lozinka,
                   String success_url, String faild_url, String error_url) {
        this.id = id;
        this.prodavacBankId = prodavac_bank_id;
        this.prodavacBankLozinka = prodavac_bank_lozinka;
        this.successUrl = success_url;
        this.failedUrl = faild_url;
        this.errorUrl = error_url;
    }

    public Klijent(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setProdavac_bank_id(String prodavac_bank_id) {
        this.prodavacBankId = prodavac_bank_id;
    }

    public void setProdavac_bank_lozinka(String prodavac_bank_lozinka) {
        this.prodavacBankLozinka = prodavac_bank_lozinka;
    }

    public void setSuccess_url(String success_url) {
        this.successUrl = success_url;
    }

    public void setFaild_url(String faild_url) {
        this.failedUrl = faild_url;
    }

    public void setError_url(String error_url) {
        this.errorUrl = error_url;
    }

    public Long getId() {
        return id;
    }


    public String getProdavac_bank_id() {
        return prodavacBankId;
    }

    public String getProdavac_bank_lozinka() {
        return prodavacBankLozinka;
    }

    public String getSuccess_url() {
        return successUrl;
    }

    public String getFaild_url() {
        return failedUrl;
    }

    public String getError_url() {
        return errorUrl;
    }
}
