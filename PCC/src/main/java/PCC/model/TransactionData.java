package PCC.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionData {

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

    public TransactionData(){}

    public TransactionData (String prodavacBankId, String prodavacBankLozinka, String bankRacunProdavac,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdavacBankId() {
        return prodavacBankId;
    }

    public void setProdavacBankId(String prodavacBankId) {
        this.prodavacBankId = prodavacBankId;
    }

    public String getProdavacBankLozinka() {
        return prodavacBankLozinka;
    }

    public void setProdavacBankLozinka(String prodavacBankLozinka) {
        this.prodavacBankLozinka = prodavacBankLozinka;
    }

    public String getBankRacunProdavac() {
        return bankRacunProdavac;
    }

    public void setBankRacunProdavac(String bankRacunProdavac) {
        this.bankRacunProdavac = bankRacunProdavac;
    }

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

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailedUrl() {
        return failedUrl;
    }

    public void setFailedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
