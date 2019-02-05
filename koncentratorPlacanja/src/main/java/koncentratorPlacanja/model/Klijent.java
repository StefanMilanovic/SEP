package koncentratorPlacanja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String imeKompanije;

    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = false, length = 70)
    private String password;

    @Column(length = 30)
    private String bankId;

    @Column(length = 100)
    private String bankPass;

    @Column(nullable = false, length = 200)
    private String successUrl;

    @Column(nullable = false, length = 200)
    private String failedUrl;

    @Column(nullable = false, length = 200)
    private String errorUrl;

    @Column(length = 80)
    private String paypalSecret;

    @Column
    private String paypalSubscribeCode;

    @Column(length = 80)
    private String bitcoinSecret;

    @Column(nullable = false)
    private boolean paypalEnabled;

    @Column(nullable = false)
    private boolean bitcoinEnabled;

    @Column(nullable = false)
    private boolean bankEnabled;

    @JsonIgnore
    @OneToMany(mappedBy = "klijent", cascade = CascadeType.ALL)
    private List<Transakcija> transakcije = new ArrayList<Transakcija>();

    public Klijent(String imeKompanije, String email, String password, String bankId, String bankPass, String successUrl,
                   String failedUrl, String errorUrl, String paypalSecret, String paypalSubscribeCode, String bitcoinSecret,
                   boolean paypalEnabled, boolean bitcoinEnabled, boolean bankEnabled) {
        this.imeKompanije = imeKompanije;
        this.email = email;
        this.password = password;
        this.bankId = bankId;
        this.bankPass = bankPass;
        this.successUrl = successUrl;
        this.failedUrl = failedUrl;
        this.errorUrl = errorUrl;
        this.paypalSecret = paypalSecret;
        this.bitcoinSecret = bitcoinSecret;
        this.paypalEnabled = paypalEnabled;
        this.bitcoinEnabled = bitcoinEnabled;
        this.bankEnabled = bankEnabled;
        this.paypalSubscribeCode = paypalSubscribeCode;
    }

    public Klijent() {}

    public String getPaypalSubscribeCode() {
        return paypalSubscribeCode;
    }

    public void setPaypalSubscribeCode(String paypalSubscribeCode) {
        this.paypalSubscribeCode = paypalSubscribeCode;
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }

    public boolean isPaypalEnabled() {
        return paypalEnabled;
    }

    public void setPaypalEnabled(boolean paypalEnabled) {
        this.paypalEnabled = paypalEnabled;
    }

    public boolean isBitcoinEnabled() {
        return bitcoinEnabled;
    }

    public void setBitcoinEnabled(boolean bitcoinEnabled) {
        this.bitcoinEnabled = bitcoinEnabled;
    }

    public boolean isBankEnabled() {
        return bankEnabled;
    }

    public void setBankEnabled(boolean bankEnabled) {
        this.bankEnabled = bankEnabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankPass() {
        return bankPass;
    }

    public void setBankPass(String bankPass) {
        this.bankPass = bankPass;
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

    public String getPaypalSecret() {
        return paypalSecret;
    }

    public void setPaypalSecret(String paypalSecret) {
        this.paypalSecret = paypalSecret;
    }

    public String getBitcoinSecret() {
        return bitcoinSecret;
    }

    public void setBitcoinSecret(String bitcoinSecret) {
        this.bitcoinSecret = bitcoinSecret;
    }

    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(List<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }
}