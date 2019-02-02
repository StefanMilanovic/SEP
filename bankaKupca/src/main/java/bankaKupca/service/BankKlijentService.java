package bankaKupca.service;

import bankaKupca.model.BankKlijent;

public interface BankKlijentService {
    BankKlijent findByKlijentId(String bank_id);
    BankKlijent findById(Long id);
}
