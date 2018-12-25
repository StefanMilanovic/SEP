package koncentratorPlacanja.model;

import java.util.Date;

public class NaucnaCentralaData {
    private double kolicina;
    private Date datum;
    private String prodavac_bank_id;


    public NaucnaCentralaData(double kolicina, Date datum, String kodProdavca) {
        this.kolicina = kolicina;
        this.datum = datum;
        this.prodavac_bank_id = kodProdavca;
    }

    public NaucnaCentralaData() {}

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