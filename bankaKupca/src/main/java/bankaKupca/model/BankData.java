package bankaKupca.model;

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
    private String bankRacunProdavac;

    @Column()
    private String bankCodeAqquirer;

    @Column()
    private String bankCodeIssuer;

    @Column()
    private String aqquirerOrderId;

    @Column()
    private Date aqquirerTimestamp;

    @Column()
    private String issuerOrderId;

    @Column()
    private Date issuerTimestamp;

    @Column()
    private String brojKartice;

    @Column()
    private String csc;

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

    @Column()
    private String result;


//    public BankData(String prodavac_bank_id, String prodavac_bank_lozinka, String success_url, String failed_url,
//                    String error_url, double kolicina, Date prodavac_vreme_transakcije, String token, String bankRacunProdavac) {
//        this.prodavacBankId = prodavac_bank_id;
//        this.prodavacBankLozinka = prodavac_bank_lozinka;
//        this.successUrl = success_url;
//        this.failedUrl = failed_url;
//        this.errorUrl = error_url;
//        this.kolicina = kolicina;
//        this.prodavac_vreme_transakcije = prodavac_vreme_transakcije;
//        this.token = token;
//        this.bankRacunProdavac = bankRacunProdavac;
//    }
    public BankData(String prodavacBankId, String prodavacBankLozinka, String bankRacunProdavac,
                    String bankCodeAqquirer, String bankCodeIssuer, String aqquirerOrderId, Date aqquirerTimestamp,
                    String issuerOrderId, Date issuerTimestamp, String brojKartice, String csc,
                    String successUrl, String failedUrl, String errorUrl, double kolicina,
                    Date prodavac_vreme_transakcije, String token, String result) {
        this.prodavacBankId = prodavacBankId;
        this.prodavacBankLozinka = prodavacBankLozinka;
        this.bankRacunProdavac = bankRacunProdavac;
        this.bankCodeAqquirer = bankCodeAqquirer;
        this.bankCodeIssuer = bankCodeIssuer;
        this.aqquirerOrderId = aqquirerOrderId;
        this.aqquirerTimestamp = aqquirerTimestamp;
        this.issuerOrderId = issuerOrderId;
        this.issuerTimestamp = issuerTimestamp;
        this.brojKartice = brojKartice;
        this.csc = csc;
        this.successUrl = successUrl;
        this.failedUrl = failedUrl;
        this.errorUrl = errorUrl;
        this.kolicina = kolicina;
        this.prodavac_vreme_transakcije = prodavac_vreme_transakcije;
        this.token = token;
        this.result = result;
    }

    public BankData(){}

    public String getBankCodeAqquirer() {
        return bankCodeAqquirer;
    }

    public void setBankCodeAqquirer(String bankCodeAqquirer) {
        this.bankCodeAqquirer = bankCodeAqquirer;
    }

    public String getBankCodeIssuer() {
        return bankCodeIssuer;
    }

    public void setBankCodeIssuer(String bankCodeIssuer) {
        this.bankCodeIssuer = bankCodeIssuer;
    }

    public String getAqquirerOrderId() {
        return aqquirerOrderId;
    }

    public void setAqquirerOrderId(String aqquirerOrderId) {
        this.aqquirerOrderId = aqquirerOrderId;
    }

    public Date getAqquirerTimestamp() {
        return aqquirerTimestamp;
    }

    public void setAqquirerTimestamp(Date aqquirerTimestamp) {
        this.aqquirerTimestamp = aqquirerTimestamp;
    }

    public String getIssuerOrderId() {
        return issuerOrderId;
    }

    public void setIssuerOrderId(String issuerOrderId) {
        this.issuerOrderId = issuerOrderId;
    }

    public Date getIssuerTimestamp() {
        return issuerTimestamp;
    }

    public void setIssuerTimestamp(Date issuerTimestamp) {
        this.issuerTimestamp = issuerTimestamp;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBankRacunProdavac() {
        return bankRacunProdavac;
    }

    public void setBankRacunProdavac(String bankRacunProdavac) {
        this.bankRacunProdavac = bankRacunProdavac;
    }

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
