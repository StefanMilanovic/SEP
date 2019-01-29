package bankaProdavca.service;

import bankaProdavca.model.BankKlijent;

public interface BankKlijentService {


    BankKlijent findByKlijentId(String bank_id);
    BankKlijent findById(Long id);
}
