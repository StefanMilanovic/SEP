package bankaProdavca.model;

public class ResultData {

    private String token;
    private String result;

    public ResultData(String token, String result) {
        this.token = token;
        this.result = result;
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
