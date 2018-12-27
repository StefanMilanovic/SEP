package bankaProdavca.service;

import bankaProdavca.model.BankKlijent;

public interface BankKlijentService {

    BankKlijent findByBankId(String bank_id);

}
