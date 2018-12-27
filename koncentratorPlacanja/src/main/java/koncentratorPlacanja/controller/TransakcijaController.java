package koncentratorPlacanja.controller;


import koncentratorPlacanja.DTO.BitcoinDTO;
import koncentratorPlacanja.DTO.BitcoinResponseDTO;
import koncentratorPlacanja.model.NaucnaCentralaData;
import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.service.KlijentService;
import koncentratorPlacanja.service.TransakcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/transakcija")
public class TransakcijaController {

    @Autowired
    private TransakcijaService transakcijaService;

    @Autowired
    private KlijentService klijentService;



    @CrossOrigin
    @RequestMapping(
            value = "/bitcoin",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> bitcoin(@RequestBody BitcoinDTO b) {
        System.out.println("\nBitcoin...\n");

        Map<String, Object> mapa = new HashMap<String,Object>();
        mapa.put("order_id", UUID.randomUUID().toString());
        mapa.put("price_amount",b.getKolicina());
        mapa.put("price_currency","USD");
        mapa.put("receive_currency","USD");
        mapa.put("title",b.getNaziv());
        mapa.put("description","desc");
        mapa.put("callback_url","https://api-sandbox.coingate.com/account/orders"); //TODO:promeniti
        mapa.put("success_url", "https://www.b92.net/");

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(mapa, headers);

        BitcoinResponseDTO response = client.postForObject("https://api-sandbox.coingate.com/v2/orders", entity, BitcoinResponseDTO.class);
        //9dc83e6f-5f90-4d23-85f5-f5ab61ce1082
        HttpHeaders noviHeaders = new HttpHeaders();
       // noviHeaders.add("Authorization", "Token 8W2cFE2hUx55MHxxuisH9gigTzdP7pRjYmQsHH2V");
        noviHeaders.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG ");

        noviHeaders.add("Location", response.getPayment_url());
        System.out.println("\nPaymentUrl" + response.getPayment_url());
        HttpEntity<BitcoinResponseDTO> entity1 = new HttpEntity<BitcoinResponseDTO>(response, noviHeaders);
        //String odg = client.postForObject(entity1.getHeaders().getLocation(), entity1, String.class); //ne moze da pogodi nas localhost...

       /* System.out.println("\n\n\t\tredirekcija: \n\n\n" + response.getPayment_url());
		r.setStatus(302);
		r.setHeader("Location", response.getPayment_url());
        r.setHeader("Access-Control-Allow-Origin", "*");*/

        System.out.println("\n Kraj Bitcoin...\n");
        return new ResponseEntity<>(response.getPayment_url(), HttpStatus.OK);
    }

    @RequestMapping(
           value = "/kreirajTransakciju",
           method = RequestMethod.POST,
           produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Transakcija> createTransaction(@RequestBody @Valid NaucnaCentralaData naucnaCentralaData) {

        Transakcija t = new Transakcija(naucnaCentralaData.getKolicina(), klijentService.findByBankId(naucnaCentralaData.getProdavacBankId()), naucnaCentralaData.getDatum());
        transakcijaService.save(t);

        return new ResponseEntity<Transakcija>(HttpStatus.OK);
    }



}
