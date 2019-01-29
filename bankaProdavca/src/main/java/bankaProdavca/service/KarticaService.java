package bankaProdavca.service;

import bankaProdavca.model.Kartica;

public interface KarticaService {
    Kartica findById(Long id);
    Kartica findByBrojKartice(String brojKartice);
    Kartica save(Kartica kartica);
}
