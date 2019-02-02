package bankaKupca.service.Impl;

import bankaKupca.model.BankData;
import bankaKupca.repository.BankDataRepository;
import bankaKupca.service.BankDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDataServiceImpl implements BankDataService {
    @Autowired
    BankDataRepository bankDataRepository;

    @Override
    public BankData findByToken(String token) {
        return bankDataRepository.findByToken(token);
    }

    @Override
    public BankData save(BankData b) {
        return bankDataRepository.save(b);
    }
}
