package koncentratorPlacanja.controller;

import koncentratorPlacanja.model.BankData;
import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.service.KlijentService;
import koncentratorPlacanja.service.TransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("banka")
public class BankaController {

    @Autowired
    private KlijentService kljentService;

    @Autowired
    private TransakcijaService transakcijaService;

    @RequestMapping(
            value = "uzmiPodatke",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BankData> uzmiPodatke(@RequestBody @Valid String id) {

        Transakcija t = transakcijaService.findOne(Long.parseLong(id));
        BankData data = new BankData(t.getKlijent_id().getBankId(), t.getKlijent_id().getBankPass(),
                t.getKlijent_id().getSuccessUrl(), t.getKlijent_id().getFailedUrl(), t.getKlijent_id().getErrorUrl(),
                t.getKolicina(), t.getProdavac_vreme_transakcije(), t.getToken(), t.getBankRacunProdavac());

        System.out.println("Saljem podatke na front end");
        System.out.println(data.getProdavac_bank_id());

       return new ResponseEntity<BankData>(data, HttpStatus.OK);
    }
}
