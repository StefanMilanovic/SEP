package bankaKupca.controller;

import bankaKupca.DTO.ResponsePayment;
import bankaKupca.model.BankData;
import bankaKupca.model.Kartica;
import bankaKupca.model.ResultData;
import bankaKupca.service.BankDataService;
import bankaKupca.service.BankKlijentService;
import bankaKupca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Date;

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
    public ResponseEntity<?> proveraAzuriranjeStanja(@RequestBody Kartica unetiPodaci, @PathVariable String id) {
        //MORA SE PROMENITI MODEL FAli preuzimanje klijenta i provera podataka unetihh sa fronta
        ResponsePayment responsePayment = new ResponsePayment();
        responsePayment.setToken(id);

        System.out.println("\nKartica kontroler...  " + id);

        BankData bankData = bankDataService.findByToken(id); // id = token
        bankData.setBrojKartice(unetiPodaci.getBrojKartice());
        bankData.setCsc(unetiPodaci.getCsc());
        bankDataService.save(bankData);

        Kartica karticaKupca = karticaService.findByBrojKartice(unetiPodaci.getBrojKartice());
        Kartica karticaProdavac = karticaService.findByBrojKartice(bankData.getBankRacunProdavac());

        if(!unetiPodaci.getBrojKartice().substring(1,6).equals("22222")){
            String full = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            SecureRandom rnd = new SecureRandom();

            StringBuilder sb = new StringBuilder(10);
            for(int i = 0; i<10; i++){
                sb.append(full.charAt(rnd.nextInt(full.length())));
            }
            String aqquirerOrderId = sb.toString();
            Date aqqurerTimestamp = new Date();
//           PccData pccData = new PccData("11111", karticaKupca.getBrojKartice().substring(1,5),
//                   aqquirerOrderId, aqqurerTimestamp, unetiPodaci.getBrojKartice(), unetiPodaci.getCsc(), null, null);
//           ResultData result = new ResultData(id, "different", pccData);
//
            bankData.setAqquirerOrderId(aqquirerOrderId);
            bankData.setAqquirerTimestamp(aqqurerTimestamp);
            bankData.setBankCodeAqquirer("22222");
            bankData.setBankCodeIssuer(unetiPodaci.getBrojKartice().substring(1,6));
            bankDataService.save(bankData);

            ResultData result = new ResultData(id, "different", bankData);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        if (karticaKupca == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        if (unetiPodaci.getBrojKartice().equals(karticaKupca.getBrojKartice()) && unetiPodaci.getCsc().equals(karticaKupca.getCsc())) {
            //prvo proveris da li ima dovoljno raspolozivo
            if (karticaKupca.getStanjeNaKartici() >= bankData.getKolicina()) {
                karticaKupca.setStanjeNaKartici(karticaKupca.getStanjeNaKartici() - bankData.getKolicina());
                karticaService.save(karticaKupca);

                karticaProdavac.setStanjeNaKartici((karticaProdavac.getStanjeNaKartici() + bankData.getKolicina()));
                karticaService.save(karticaProdavac);
                responsePayment.setUrl(bankData.getSuccess_url());
                System.out.println("Uspesno placanje !");

                bankData.setResult("success");
                bankDataService.save(bankData);

                ResultData result = new ResultData(id,"success", bankData);

                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                System.out.println(" Upozorenje! Nema dovoljno na racunu !");

                bankData.setResult("failure");
                bankDataService.save(bankData);

                ResultData result = new ResultData(id,"failure", bankData);;

                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } else {
            System.out.println(" Upozorenje! Pogresan PAN ili CSC !");
            return new ResponseEntity<>(null, HttpStatus.OK);

        }
    }
}
