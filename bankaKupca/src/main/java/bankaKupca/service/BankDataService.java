package bankaKupca.service;

import bankaKupca.model.BankData;

public interface BankDataService {
    BankData findByToken(String token);
    BankData save (BankData b);
}
