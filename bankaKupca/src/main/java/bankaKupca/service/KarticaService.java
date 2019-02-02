package bankaKupca.service;

import bankaKupca.model.Kartica;

public interface KarticaService {
    Kartica findById(Long id);
    Kartica findByBrojKartice(String brojKartice);
    Kartica save(Kartica kartica);
}
