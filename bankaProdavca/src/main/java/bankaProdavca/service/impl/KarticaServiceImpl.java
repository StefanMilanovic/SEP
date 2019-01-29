package bankaProdavca.service.impl;

import bankaProdavca.model.Kartica;
import bankaProdavca.repository.KarticaRepository;
import bankaProdavca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KarticaServiceImpl implements KarticaService {
//MEtoda koja na osnovu vlasnika kartice trazi klijenta pa  iz klijenta njegov ID

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
