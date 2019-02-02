package bankaKupca.service.Impl;

import bankaKupca.model.Kartica;
import bankaKupca.repository.KarticaRepository;
import bankaKupca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KarticaServiceImpl implements KarticaService {
    @Autowired
    KarticaRepository karticaRepository;

    @Override
    public Kartica findById(Long id) {
        return karticaRepository.findById(id);
    }

    @Override
    public Kartica findByBrojKartice(String brojKartice) {
        return karticaRepository.findByBrojKartice(brojKartice);
    }



    @Override
    public Kartica save(Kartica kartica) {
        return karticaRepository.save(kartica);
    }
}
