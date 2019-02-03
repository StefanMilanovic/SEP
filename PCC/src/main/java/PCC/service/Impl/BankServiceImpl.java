package PCC.service.Impl;

import PCC.model.Bank;
import PCC.repository.BankRepository;
import PCC.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank findByKod(String kod) {
        return this.bankRepository.findByKodBanke(kod);
    }
}
