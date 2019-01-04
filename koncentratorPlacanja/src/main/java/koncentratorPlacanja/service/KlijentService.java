package koncentratorPlacanja.service;

import koncentratorPlacanja.model.Klijent;

import java.util.List;

public interface KlijentService {

    Klijent findOne(Long id);

    Klijent save(Klijent user);

    Klijent findByBankId(String prodavac_bank_id);

    Klijent findByemail (String email);

    void delete(Long id);

    List<Klijent> findAll();
}
