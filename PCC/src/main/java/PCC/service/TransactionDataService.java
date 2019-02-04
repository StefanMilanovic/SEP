package PCC.service;

import PCC.model.TransactionData;

public interface TransactionDataService {

    TransactionData save (TransactionData data);

    TransactionData findByToken(String token);
}
