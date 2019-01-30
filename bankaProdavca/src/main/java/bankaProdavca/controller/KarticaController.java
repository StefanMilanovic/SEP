package bankaProdavca.controller;
import bankaProdavca.DTO.ResponsePayment;
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
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponsePayment> proveraAzuriranjeStanja(@RequestBody Kartica unetiPodaci, @PathVariable String id){


       //MORA SE PROMENITI MODEL FAli preuzimanje klijenta i provera podataka unetihh sa fronta
        ResponsePayment responsePayment = new ResponsePayment();
        responsePayment.setToken(id);
        System.out.println("\nKartica kontroler...  " + id);
        BankData bankData = bankDataService.findByToken(id); // id = token
        System.out.println("\n kolicina za skidanje :  " + bankData.getKolicina());

        Kartica karticaKupca = karticaService.findByBrojKartice(unetiPodaci.getBrojKartice());
        Kartica karticaProdavac = karticaService.findByBrojKartice(bankData.getBankRacunProdavac());

        System.out.println("\n Vlasnik kartice kupca  :  " + karticaKupca.getVlasnikKartice());
        //provera pan


        //da li se pin i csc poklapaju
        System.out.println("\n Pan uneti:" + unetiPodaci.getPan() + "\n Pan kartica:" + karticaKupca.getPan() +"\n csc uneti:" + unetiPodaci.getCsc() +"\n csc kartica:" + karticaKupca.getCsc());
        if(unetiPodaci.getPan().equals(karticaKupca.getPan()) && unetiPodaci.getCsc().equals(karticaKupca.getCsc())) {
        //prvo proveris da li ima dovoljno raspolozivo
            if(karticaKupca.getStanjeNaKartici() >= bankData.getKolicina() ){
                karticaKupca.setStanjeNaKartici(karticaKupca.getStanjeNaKartici() - bankData.getKolicina() );
                karticaService.save(karticaKupca);

                karticaProdavac.setStanjeNaKartici((karticaProdavac.getStanjeNaKartici() + bankData.getKolicina()));
                karticaService.save(karticaProdavac);
                responsePayment.setUrl(bankData.getSuccess_url());
                System.out.println("Uspesno placanje !");
                return new ResponseEntity<>(responsePayment, HttpStatus.OK);
            }else{
                System.out.println(" Upozorenje! Nema dovoljno na racunu !");
                responsePayment.setUrl(bankData.getFailed_url());
                return new ResponseEntity<>(responsePayment,HttpStatus.BAD_REQUEST);
            }
        }else{
            System.out.println(" Upozorenje! Pogresan PAN ili CSC !");
            responsePayment.setUrl(bankData.getFailed_url());
            return new ResponseEntity<>(responsePayment,HttpStatus.BAD_REQUEST);
        }
        //dodaj na racun naucne centrale

        // bank data uzimam preko tokena i tu sumu skidam sa kratice
        //kartica id nucne cetnrale ce biti isto u bank data i tu dodajem novac

        /*Long newId = Long.parseLong(id); //ID naucne centrale kojoj saljem pare u banci
        BankKlijent klijent = bankKlijentService.findById(newId);
       // Kartica karticaIzBaze = karticaService.findByVlasnikId(newId); ///

        */

    }
}
