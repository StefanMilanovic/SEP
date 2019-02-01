package koncentratorPlacanja.service.impl;

import koncentratorPlacanja.model.Bank;
import koncentratorPlacanja.model.Klijent;
import koncentratorPlacanja.repository.BankRepository;
import koncentratorPlacanja.repository.KlijentRepository;
import koncentratorPlacanja.service.BankService;
import koncentratorPlacanja.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank findOne(Long id) {
        return bankRepository.findOne(id);
    }

    @Override
    public Bank save(Bank user) {
        return bankRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        bankRepository.delete(id);
    }


    @Override
    public Bank findByKodBanke(String kodBanke) {
        return bankRepository.findByKodBanke(kodBanke);
    }
}
