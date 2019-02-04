package PCC.service.Impl;

import PCC.model.TransactionData;
import PCC.repository.TransacrionDataRepository;
import PCC.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDataServiceImpl implements TransactionDataService {

    @Autowired
    private TransacrionDataRepository transacrionDataRepository;

    @Override
    public TransactionData save(TransactionData data) {
        return this.transacrionDataRepository.save(data);
    }

    @Override
    public TransactionData findByToken(String token){
        return transacrionDataRepository.findByToken(token);
    }

}
