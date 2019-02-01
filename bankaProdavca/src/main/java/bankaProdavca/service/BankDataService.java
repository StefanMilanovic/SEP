package bankaProdavca.service;

import bankaProdavca.model.BankData;

public interface BankDataService {
    BankData findByToken(String token);
    BankData save (BankData b);
}
