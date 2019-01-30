package koncentratorPlacanja.model;

import java.util.Date;

public class NaucnaCentralaData {
    private double kolicina;
    private Date datum;
    private String prodavac_bank_id;
    private String bankRacunProdavca;


    public NaucnaCentralaData(double kolicina, Date datum, String kodProdavca, String bankRacunProdavca) {
        this.kolicina = kolicina;
        this.datum = datum;
        this.prodavac_bank_id = kodProdavca;
        this.bankRacunProdavca = bankRacunProdavca;
    }

    public NaucnaCentralaData() {}

    public String getBankRacunProdavca() {
        return bankRacunProdavca;
    }

    public void setBankRacunProdavca(String bankRacunProdavca) {
        this.bankRacunProdavca = bankRacunProdavca;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getProdavacBankId() {
        return prodavac_bank_id;
    }

    public void setProdavacBankId(String kodProdavca) {
        this.prodavac_bank_id = kodProdavca;
    }
}