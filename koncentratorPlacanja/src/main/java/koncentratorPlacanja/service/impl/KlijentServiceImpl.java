package koncentratorPlacanja.service.impl;

import koncentratorPlacanja.model.Klijent;
import koncentratorPlacanja.repository.KlijentRepository;
import koncentratorPlacanja.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlijentServiceImpl implements KlijentService {

    @Autowired
    private KlijentRepository klijentRepository;

    @Override
    public List<Klijent> findAll() {
        return klijentRepository.findAll();
    }

    @Override
    public Klijent findOne(Long id) {
        return klijentRepository.findOne(id);
    }

    @Override
    public Klijent save(Klijent user) {
        return klijentRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        klijentRepository.delete(id);
    }
}
