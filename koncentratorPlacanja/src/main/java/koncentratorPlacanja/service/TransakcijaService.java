package koncentratorPlacanja.service;

import koncentratorPlacanja.model.Transakcija;

import java.util.List;


public interface TransakcijaService {

    Transakcija findOne(Long id);
    List<Transakcija> findAll();
    Transakcija findByToken( String token);
    Transakcija save(Transakcija t);
    void delete(Transakcija t);
}
