package bankaProdavca.controller;
import bankaProdavca.model.BankData;
import bankaProdavca.model.BankKlijent;
import bankaProdavca.model.Kartica;
import bankaProdavca.service.BankDataService;
import bankaProdavca.service.BankKlijentService;
import bankaProdavca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/karticaController")
public class KarticaController {

    @Autowired
    BankDataService bankDataService;

    @Autowired
    BankKlijentService bankKlijentService;

    @Autowired
    KarticaService karticaService;



    @RequestMapping(
            value = "/proveraAzuriranjeStanja/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<BankKlijent> proveraAzuriranjeStanja(@RequestBody @Valid Kartica karticaPodaci, @PathVariable String id){
       //MORA SE PROMENITI MODEL FAli preuzimanje klijenta i provera podataka unetihh sa fronta
        System.out.println("\nkaritcPodaci :  " + karticaPodaci);
        Long newId = Long.parseLong(id); //ID naucne centrale kojoj saljem pare u banci
        BankKlijent klijent = bankKlijentService.findById(newId);
       // Kartica karticaIzBaze = karticaService.findByVlasnikId(newId); ///

        Kartica kartica = new Kartica();
        kartica.setPAN(karticaPodaci.getPAN());
        kartica.setPIN(karticaPodaci.getPIN());
        kartica.setVlasnik(karticaPodaci.getVlasnik());
        kartica.setDatumIsteka(karticaPodaci.getDatumIsteka());
        kartica.setVlasnik(klijent);
        kartica.setStanjeNaKartici(1000000);


        if(klijent != null){
          //  if(klijent.getKlijentLozinka().equals(b.getProdavac_bank_lozinka())){
                return new ResponseEntity<BankKlijent>(klijent, HttpStatus.OK);
            //}
        }
        return null;
    }
}
