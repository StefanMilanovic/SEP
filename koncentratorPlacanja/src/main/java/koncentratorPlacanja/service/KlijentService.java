package koncentratorPlacanja.service;

import koncentratorPlacanja.model.Klijent;

import java.util.List;

public interface KlijentService {

    Klijent findOne(Long id);

    Klijent save(Klijent user);

    void delete(Long id);

    List<Klijent> findAll();
}
