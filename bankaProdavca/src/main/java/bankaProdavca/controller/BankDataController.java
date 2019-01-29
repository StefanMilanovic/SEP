package bankaProdavca.controller;

import bankaProdavca.model.BankData;
import bankaProdavca.model.BankKlijent;
import bankaProdavca.service.BankDataService;
import bankaProdavca.service.BankKlijentService;
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
    public ResponseEntity<BankKlijent> uzmiPodatke(@RequestBody @Valid String id){
        System.out.println("ID JE: " + id);
        BankData b = bankDataService.findByToken(id);
        BankKlijent klijent = bankKlijentService.findByBankId(b.getProdavac_bank_id());
        if(klijent != null){
            if(klijent.getKlijentLozinka().equals(b.getProdavac_bank_lozinka())){
                return new ResponseEntity<BankKlijent>(klijent, HttpStatus.OK);
            }
        }
        return null;
    }
}