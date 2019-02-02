package bankaKupca.controller;

import bankaKupca.model.BankData;
import bankaKupca.model.BankKlijent;
import bankaKupca.service.BankDataService;
import bankaKupca.service.BankKlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bankController")
public class BankDataController {

    @Autowired
    BankDataService bankDataService;

    @Autowired
    BankKlijentService bankKlijentService;

    @RequestMapping(
            value = "/proveriPodatke",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<BankKlijent> uzmiPodatke(@RequestBody @Valid String token){
        System.out.println("Token je: " + token);
        BankData b = bankDataService.findByToken(token);
        BankKlijent klijent = bankKlijentService.findByKlijentId(b.getProdavac_bank_id());
        if(klijent != null){
            System.out.println("Token je: " + token);
            if(klijent.getKlijentLozinka().equals(b.getProdavac_bank_lozinka())){
                return new ResponseEntity<BankKlijent>(klijent, HttpStatus.OK);
            }
        }
        return null;
    }

}
