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
    private String prodavac_bank_id;

    @Column(nullable = false, length = 100)
    private String prodavac_bank_lozinka;

    @Column(nullable = false, length = 200)
    private String success_url;

    @Column(nullable = false, length = 200)
    private String failed_url;

    @Column(nullable = false, length = 200)
    private String error_url;

    @OneToMany(mappedBy = "klijent", cascade = CascadeType.ALL)
    private List<Transakcija> transakcije = new ArrayList<Transakcija>();

    public Klijent(Long id, String prodavac_bank_id, String prodavac_bank_lozinka,
                   String success_url, String faild_url, String error_url) {
        this.id = id;
        this.prodavac_bank_id = prodavac_bank_id;
        this.prodavac_bank_lozinka = prodavac_bank_lozinka;
        this.success_url = success_url;
        this.failed_url = faild_url;
        this.error_url = error_url;
    }

    public Klijent(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setProdavac_bank_id(String prodavac_bank_id) {
        this.prodavac_bank_id = prodavac_bank_id;
    }

    public void setProdavac_bank_lozinka(String prodavac_bank_lozinka) {
        this.prodavac_bank_lozinka = prodavac_bank_lozinka;
    }

    public void setSuccess_url(String success_url) {
        this.success_url = success_url;
    }

    public void setFaild_url(String faild_url) {
        this.failed_url = faild_url;
    }

    public void setError_url(String error_url) {
        this.error_url = error_url;
    }

    public Long getId() {
        return id;
    }


    public String getProdavac_bank_id() {
        return prodavac_bank_id;
    }

    public String getProdavac_bank_lozinka() {
        return prodavac_bank_lozinka;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public String getFaild_url() {
        return failed_url;
    }

    public String getError_url() {
        return error_url;
    }
}
