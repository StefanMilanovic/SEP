package koncentratorPlacanja.controller;

import koncentratorPlacanja.service.KlijentService;
import koncentratorPlacanja.service.TransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banka")
public class BankaController {

    @Autowired
    private KlijentService kljentService;

    @Autowired
    private TransakcijaService transakcijaService;

}
