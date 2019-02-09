package koncentratorPlacanja.controller;


import koncentratorPlacanja.DTO.BitcoinResponseDTO;
import koncentratorPlacanja.model.*;
import koncentratorPlacanja.service.KlijentService;
import koncentratorPlacanja.service.TransakcijaService;
import koncentratorPlacanja.service.ZavrsenaTransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("transakcija")
public class TransakcijaController {

    @Autowired
    private TransakcijaService transakcijaService;

    @Autowired
    private KlijentService klijentService;

    @Autowired
    private ZavrsenaTransakcijaService zavrsenaTransakcijaService;

    @CrossOrigin
    @RequestMapping(
            value = "/kriptovaluta/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> kriptovaluta(@PathVariable String id) {
        System.out.println("\nBitcoin...");

        Transakcija t = this.transakcijaService.findOne(Long.parseLong(id));
        Klijent k = t.getKlijent_id();
        System.out.println("Klijent : " + k.getImeKompanije());
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("order_id", UUID.randomUUID().toString());
        map.put("price_amount",t.getKolicina() + "");
        map.put("price_currency","USD");
        map.put("receive_currency","USD");
        map.put("title",k.getImeKompanije() + "");
        map.put("description","desc");
        map.put("callback_url","https://api-sandbox.coingate.com/account/orders");// https://api-sandbox.coingate.com/account/orders
        map.put("success_url", "http://localhost:4200/rezultat/success/"+ t.getToken());
        map.put("cancel_url","http://localhost:4200/rezultat/failure/"+ t.getToken());

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Token " + k.getBitcoinSecret() + "");

        HttpEntity<Map<String, Object>> httpe = new HttpEntity<Map<String,Object>>(map, headers);

        BitcoinResponseDTO response = client.postForObject("https://api-sandbox.coingate.com/v2/orders", httpe, BitcoinResponseDTO.class);

        HttpHeaders h = new HttpHeaders();

        h.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG ");
        h.add("Location", response.getPayment_url());
        System.out.println("\nPaymentUrl -> " + response.getPayment_url());
        HttpEntity<BitcoinResponseDTO> entity1 = new HttpEntity<BitcoinResponseDTO>(response, h);

        System.out.println("\n Kraj Bitcoin...\n");
        BankData b = new BankData();//response.getPayment_url()
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(
           value = "/kreirajTransakciju",
           method = RequestMethod.POST,
           produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Transakcija> createTransaction(@RequestBody @Valid KoncentratorData naucnaCentralaData) {

        Transakcija t = new Transakcija(naucnaCentralaData.getPrice(), klijentService.findOne(Long.parseLong(naucnaCentralaData.getClientId())),
                naucnaCentralaData.getDate(), naucnaCentralaData.getBankAccount());
        transakcijaService.save(t);

        return new ResponseEntity<Transakcija>(transakcijaService.findByToken(t.getToken()), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/nadjiTransakciju/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Transakcija> nadjiTransakciju(@PathVariable String id){

        Transakcija retVal = this.transakcijaService.findOne(Long.parseLong(id));
        if(retVal == null)
            return null;
        else
            return new ResponseEntity<Transakcija>(retVal, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/nadjiKlijentaTransakcije/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Klijent> nadjiKlijentaTransakcije(@PathVariable String id){

        Transakcija transakcija = this.transakcijaService.findOne(Long.parseLong(id));
        Klijent klijent = transakcija.getKlijent_id();
        if(klijent == null)
            return null;
        else
            return new ResponseEntity<Klijent>(klijent, HttpStatus.OK);
    }

    @RequestMapping(
            value = "resultTransakcija/{token}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> resultTransaction(@PathVariable String token, @RequestBody @Valid String result) {

        Transakcija tempTransakcija = transakcijaService.findByToken(token);
        Klijent retKlijent = klijentService.findOne(tempTransakcija.getKlijent_id().getId());
        if(tempTransakcija != null) {
            ZavrsenaTransakcija zavrsenaTransakcija = new ZavrsenaTransakcija(tempTransakcija.getToken(), tempTransakcija.getKolicina(),
                    tempTransakcija.getKlijent_id(), tempTransakcija.getBankRacunProdavac(), result);

            zavrsenaTransakcijaService.save(zavrsenaTransakcija);
            transakcijaService.delete(tempTransakcija);

            return new ResponseEntity<Klijent>(retKlijent, HttpStatus.OK);
        }
        else{
            return null;
        }
    }

}
