package bankaProdavca.service.impl;

import bankaProdavca.repository.BankKlijentRepository;
import bankaProdavca.service.BankKlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankKlijentServiceImpl implements BankKlijentService {

    @Autowired
    private BankKlijentRepository bankKlijentRepository;
}
