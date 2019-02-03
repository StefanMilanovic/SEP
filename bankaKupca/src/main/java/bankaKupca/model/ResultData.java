package bankaKupca.model;

public class ResultData {
    private String token;
    private String result;
    private BankData bankData;

    public ResultData(String token, String result, BankData bankData) {
        this.token = token;
        this.result = result;
        this.bankData = bankData;
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

    public BankData getBankData() {
        return bankData;
    }

    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }
}
