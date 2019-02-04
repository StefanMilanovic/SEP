package bankaProdavca.controller;

import bankaProdavca.model.BankData;
import bankaProdavca.model.Kartica;
import bankaProdavca.model.ResultData;
import bankaProdavca.service.BankDataService;
import bankaProdavca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bankPccController")
public class PccController {

    @Autowired
    private BankDataService bankDataService;

    @Autowired
    private KarticaService karticaService;

    @RequestMapping(
            value = "/zavrsiPccTransakciju",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResultData> zavrsiPccTransakciju(@RequestBody BankData data){
        BankData bankData = bankDataService.findByToken(data.getToken());
        bankDataService.save(bankData);

        Kartica k = karticaService.findByBrojKartice(bankData.getBankRacunProdavac());
        k.setStanjeNaKartici(k.getStanjeNaKartici() + bankData.getKolicina());
        karticaService.save(k);

        ResultData resultData = new ResultData(bankData.getToken(), bankData.getResult(), bankData);
        return new ResponseEntity<ResultData>(resultData, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/obradiPccTransakciju",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResultData> obradiPccTransakciju(@RequestBody BankData data){

        String full = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(10);
        for(int i = 0; i<10; i++){
            sb.append(full.charAt(rnd.nextInt(full.length())));
        }

        String issuerOrderId = sb.toString();
        Date issuerOrderTimestamp = new Date();

        BankData bankData = data;

        bankData.setIssuerOrderId(issuerOrderId);
        bankData.setIssuerTimestamp(issuerOrderTimestamp);

        bankDataService.save(bankData);

        Kartica kartica = karticaService.findByBrojKartice(data.getBrojKartice());

        if(kartica == null){
            return null;
        }

        if(data.getBrojKartice().equals(kartica.getBrojKartice()) && data.getCsc().equals(kartica.getCsc())) {
            if(kartica.getStanjeNaKartici() >= data.getKolicina()){
                kartica.setStanjeNaKartici(kartica.getStanjeNaKartici() - data.getKolicina());
                karticaService.save(kartica);

                bankData.setResult("success");
                bankDataService.save(bankData);

                ResultData resultData = new ResultData(data.getToken(), "success", bankData);
                return new ResponseEntity<ResultData>(resultData, HttpStatus.OK);
            }
            else{
                bankData.setResult("failure");
                bankDataService.save(bankData);

                ResultData resultData = new ResultData(data.getToken(), "failure", bankData);
                return new ResponseEntity<>(resultData,HttpStatus.OK);
            }
        }
        return null;
    }

}
