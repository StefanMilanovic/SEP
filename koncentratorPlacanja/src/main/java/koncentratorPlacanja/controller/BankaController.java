package koncentratorPlacanja.controller;

import koncentratorPlacanja.model.Bank;
import koncentratorPlacanja.model.BankData;
import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.service.BankService;
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


    @Autowired
    private BankService bankService;

    @RequestMapping(
            value = "pripremiPodatke",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BankData> pripremiPodatke(@RequestBody @Valid String id) {

        Transakcija t = transakcijaService.findOne(Long.parseLong(id));
        BankData data = new BankData(t.getKlijent_id().getBankId(), t.getKlijent_id().getBankPass(),
                t.getKlijent_id().getSuccessUrl(), t.getKlijent_id().getFailedUrl(), t.getKlijent_id().getErrorUrl(),
                t.getKolicina(), t.getProdavac_vreme_transakcije(), t.getToken(), t.getBankRacunProdavac());

        System.out.println("Saljem podatke na front end");
        System.out.println(data.getProdavac_bank_id());

       return new ResponseEntity<BankData>(data, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/getNazivBanke/{token}",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getNazivBanke(@PathVariable String token){

        Transakcija transakcija = transakcijaService.findByToken(token);
        String racun =transakcija.getBankRacunProdavac();
        System.out.println("\nRacun : " + racun);
        String retVal = racun.substring(1, 1 + 5);
        System.out.println("\nretVal : " + retVal);
        if(retVal == null) {
            return null;
        }
        else {
            if(retVal == "11111" ){
                return new ResponseEntity<>(retVal, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(retVal, HttpStatus.OK);
            }
        }
    }

    @RequestMapping(
            value = "/getUrlBank/{codeBank}",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getUrlBank(@PathVariable String codeBank){

        Bank bank = bankService.findByKodBanke(codeBank);
        String urlBank =bank.getUrlBanke();
        System.out.println("\nUrl "+ bank.getNazivBanke()+" : " + bank.getUrlBanke());

        if(urlBank == null) {
            return null;
        }
        else {

            return new ResponseEntity<>(bank, HttpStatus.OK);

        }
    }
}
