package bankaProdavca.service.impl;

import bankaProdavca.model.BankData;
import bankaProdavca.repository.BankDataRepository;
import bankaProdavca.service.BankDataService;
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
}
