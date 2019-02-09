package koncentratorPlacanja.model;

import java.util.Date;

public class KoncentratorData {
    private double price;
    private String bankAccount;
    private String clientId;
    private Date date;


    public KoncentratorData(double price, String bankAccount, String clientId, Date date) {
        this.price = price;
        this.bankAccount = bankAccount;
        this.clientId = clientId;
        this.date = date;
    }

    public KoncentratorData() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}