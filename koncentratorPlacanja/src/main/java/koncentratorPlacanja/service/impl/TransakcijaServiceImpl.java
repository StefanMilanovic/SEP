package koncentratorPlacanja.service.impl;

import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.repository.TransakcijaRepository;
import koncentratorPlacanja.service.TransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Override;
import java.util.List;

@Service
public class TransakcijaServiceImpl implements TransakcijaService {
    @Autowired
    private TransakcijaRepository tansakcijaRepository;

    @Override
    public Transakcija findOne(Long id) {
        return tansakcijaRepository.findById(id);
    }

    @Override
    public List<Transakcija> findAll() {
        return tansakcijaRepository.findAll();
    }

    @Override
    public Transakcija findByToken(String token) {
        return tansakcijaRepository.findByToken(token);
    }

    @Override
    public Transakcija save(Transakcija t) {
       return tansakcijaRepository.save(t);
    }

    @Override
    public void delete(Transakcija t) { tansakcijaRepository.delete(t); }

}
