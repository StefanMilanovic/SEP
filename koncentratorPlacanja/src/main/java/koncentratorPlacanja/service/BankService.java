package koncentratorPlacanja.service;

import koncentratorPlacanja.model.Bank;
import koncentratorPlacanja.model.Klijent;

import java.util.List;

public interface BankService {

    Bank findOne(Long id);

    Bank findByKodBanke(String kodBanke);

    Bank save(Bank bank);

    void delete(Long id);

    List<Bank> findAll();
}
