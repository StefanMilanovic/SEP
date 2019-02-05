package koncentratorPlacanja.controller;

import koncentratorPlacanja.model.PayPalData;
import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.service.TransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payPal")
public class PayPalController {

    @Autowired
    private TransakcijaService transakcijaService;

    @RequestMapping(
            value = "uzmiPayPalPodatke/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<PayPalData> nadjiTransakciju(@PathVariable String id){

        Transakcija t = this.transakcijaService.findOne(Long.parseLong(id));
        PayPalData data = new PayPalData(t.getKlijent_id().getSuccessUrl(), t.getKlijent_id().getFailedUrl(), t.getKlijent_id().getErrorUrl(),
                t.getKolicina(), t.getKlijent_id().getPaypalSecret(), t.getToken(), t.getKlijent_id().getPaypalSubscribeCode());

        return new ResponseEntity<PayPalData>(data, HttpStatus.OK);
    }

}
