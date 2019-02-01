package koncentratorPlacanja.service.impl;

import koncentratorPlacanja.model.ZavrsenaTransakcija;
import koncentratorPlacanja.repository.ZavrsenaTransakcijaRepository;
import koncentratorPlacanja.service.ZavrsenaTransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZavrsenaTransakcijaImpl implements ZavrsenaTransakcijaService {

    @Autowired
    private ZavrsenaTransakcijaRepository zavrsenaTransakcijaRepository;

    @Override
    public ZavrsenaTransakcija save(ZavrsenaTransakcija zt) {
        return this.zavrsenaTransakcijaRepository.save(zt);
    }
}
