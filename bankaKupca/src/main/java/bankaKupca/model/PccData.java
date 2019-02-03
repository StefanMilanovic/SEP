package bankaKupca.model;

import java.util.Date;

public class PccData {
    //AQQUIRER - BANKA KOJA SALJE PODATTKE - BANKA PRODAVCA
    //ISSUER - BANKA KOAJ PRIMA PODATKE - BANKA KUPCA
    private String bankCodeAqquirer;
    private String bankCodeIssuer;
    private String aqquirerOrderId;
    private Date aqquirerTimestamp;
    private String issuerOrderId;
    private Date issuerTimestamp;
    private String brojKartice;
    private String csc;

    public PccData(String bankCodeAqquirer, String bankCodeIssuer, String aqquirerOrderId, Date aqquirerTimestamp, String brojKartice, String csc, String issuerOrderId, Date issuerTimestamp) {
        this.bankCodeAqquirer = bankCodeAqquirer;
        this.bankCodeIssuer = bankCodeIssuer;
        this.aqquirerOrderId = aqquirerOrderId;
        this.aqquirerTimestamp = aqquirerTimestamp;
        this.brojKartice = brojKartice;
        this.csc = csc;
        this.issuerOrderId = issuerOrderId;
        this.issuerTimestamp = issuerTimestamp;
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
}
