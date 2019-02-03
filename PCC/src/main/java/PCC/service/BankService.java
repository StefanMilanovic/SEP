package PCC.service;

import PCC.model.Bank;

public interface BankService {
    Bank findByKod(String kod);
}
