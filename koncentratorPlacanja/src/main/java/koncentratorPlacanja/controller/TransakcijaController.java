package koncentratorPlacanja.controller;


import koncentratorPlacanja.model.Transakcija;
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

@RestController
@RequestMapping("/transakcija")
public class TransakcijaController {

    @Autowired
    private TransakcijaService transakcijaService;
    private Transakcija trenutnaTransakcija = new Transakcija();


    @RequestMapping(
            value = "/kreirajTransakciju",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> startTransaction(@RequestBody @Valid Transakcija transakcija) {

        Transakcija t = transakcijaService.findOne(1L);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                "http://localhost:4200/#/tt/" + t.getToken());
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }


    @RequestMapping(
            value = "/kriptovaluta",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUser(/*@PathVariable String token*/) {

        String token = "qweqweqwe"; //PRIVREMENO !!!
        System.out.println("\nTransakcija kontroler \n");
        Transakcija transakcija = transakcijaService.findOne(1L);


        String testAdress = "https://sandbox.coingate.com/pay/TestTest";
        RestTemplate restClient = new RestTemplate();


        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/x-www-form-urlencoded");
            headers.set("Authorization", "Token qweqweqwe");

            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("order_id", transakcija.getId() + "");
            map.add("price_amount", transakcija.getKolicina() + "");
            map.add("price_currency", "USD");
            map.add("receive_currency", "USD");
            map.add("title", token);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            ResponseEntity<String> response = restClient.postForEntity(testAdress, request, String.class);

            JsonParser basicJsonParser = new BasicJsonParser();
            String paymentUrl = (String)basicJsonParser.parseMap(response.getBody()).get("payment_url");

            return new ResponseEntity<String>(paymentUrl, HttpStatus.OK);

        }catch (Exception ex) {

            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }



}
