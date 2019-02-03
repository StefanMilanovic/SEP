package PCC.model;

public class BankResponse {

    private TransactionData transactionData;
    private Bank bank;

    public BankResponse(TransactionData transactionData, Bank bank) {
        this.transactionData = transactionData;
        this.bank = bank;
    }

    public TransactionData getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
