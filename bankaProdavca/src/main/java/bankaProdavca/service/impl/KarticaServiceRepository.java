package bankaProdavca.service.impl;

import bankaProdavca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KarticaServiceRepository implements KarticaService {

    @Autowired
    private KarticaServiceRepository karticaServiceRepository;
}
