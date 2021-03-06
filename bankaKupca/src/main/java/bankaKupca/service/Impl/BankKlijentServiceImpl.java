package bankaKupca.service.Impl;

import bankaKupca.model.BankKlijent;
import bankaKupca.repository.BankKlijentRepository;
import bankaKupca.service.BankKlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankKlijentServiceImpl implements BankKlijentService {

    @Autowired
    private BankKlijentRepository bankKlijentRepository;

    @Override
    public BankKlijent findByKlijentId(String klijentId) {
        return bankKlijentRepository.findByKlijentId(klijentId);
    }

    @Override
    public BankKlijent findById(Long id) {
        return bankKlijentRepository.findById(id);
    }

}
