package bankaProdavca.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BankData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String prodavacBankId;

    @Column()
    private String prodavacBankLozinka;


    @Column()
    private String successUrl;

    @Column()
    private String failedUrl;

    @Column()
    private String errorUrl;

    @Column()
    private double kolicina;

    @Column()
    private Date prodavac_vreme_transakcije;

    @Column()
    private String token;


    public BankData(String prodavac_bank_id, String prodavac_bank_lozinka, String success_url, String failed_url,
                    String error_url, double kolicina, Date prodavac_vreme_transakcije, String token) {
        this.prodavacBankId = prodavac_bank_id;
        this.prodavacBankLozinka = prodavac_bank_lozinka;
        this.successUrl = success_url;
        this.failedUrl = failed_url;
        this.errorUrl = error_url;
        this.kolicina = kolicina;
        this.prodavac_vreme_transakcije = prodavac_vreme_transakcije;
        this.token = token;
    }

    public BankData(){}

    public String getProdavac_bank_id() {
        return prodavacBankId;
    }

    public void setProdavac_bank_id(String prodavac_bank_id) {
        this.prodavacBankId = prodavac_bank_id;
    }

    public String getProdavac_bank_lozinka() {
        return prodavacBankLozinka;
    }

    public void setProdavac_bank_lozinka(String prodavac_bank_lozinka) {
        this.prodavacBankLozinka = prodavac_bank_lozinka;
    }

    public String getSuccess_url() {
        return successUrl;
    }

    public void setSuccess_url(String success_url) {
        this.successUrl = success_url;
    }

    public String getFailed_url() {
        return failedUrl;
    }

    public void setFailed_url(String failed_url) {
        this.failedUrl = failed_url;
    }

    public String getError_url() {
        return errorUrl;
    }

    public void setError_url(String error_url) {
        this.errorUrl = error_url;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Date getProdavac_vreme_transakcije() {
        return prodavac_vreme_transakcije;
    }

    public void setProdavac_vreme_transakcije(Date prodavac_vreme_transakcije) {
        this.prodavac_vreme_transakcije = prodavac_vreme_transakcije;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
