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
            value = "/kriptovaluta",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> bitcoin(@RequestBody BitcoinDTO b) {
        System.out.println("\nBitcoin...");

        Map<String, Object> mapa = new HashMap<String,Object>();
        mapa.put("order_id", UUID.randomUUID().toString());
        mapa.put("price_amount",b.getKolicina() + "");
        mapa.put("price_currency","USD");
        mapa.put("receive_currency","USD");
        mapa.put("title",b.getNaziv() + "");
        mapa.put("description","desc");
        mapa.put("callback_url","https://api-sandbox.coingate.com/account/orders");// https://api-sandbox.coingate.com/account/orders
        mapa.put("success_url", "https://www.b92.net/");

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(mapa, headers);

        BitcoinResponseDTO response = client.postForObject("https://api-sandbox.coingate.com/v2/orders", entity, BitcoinResponseDTO.class);

        HttpHeaders noviHeaders = new HttpHeaders();

        noviHeaders.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG ");

        noviHeaders.add("Location", response.getPayment_url());
        System.out.println("\nPaymentUrl -> " + response.getPayment_url());
        HttpEntity<BitcoinResponseDTO> entity1 = new HttpEntity<BitcoinResponseDTO>(response, noviHeaders);

        System.out.println("\n Kraj Bitcoin...\n");
        return new ResponseEntity<>(response.getPayment_url(), HttpStatus.OK);
    }


    @CrossOrigin
    @RequestMapping(
            value = "/kriptovaluta2",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> bitcoin2() {
        String url = "https://api-sandbox.coingate.com/v2/orders";
        BitcoinDTO b  = new BitcoinDTO("13","AAAA");
        try {
            System.out.println("Usao");
            RestTemplate restClient = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/x-www-form-urlencoded");
            headers.set("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG");

            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("order_id", b.getNaziv() + "");
            map.add("price_amount", b.getKolicina() + "");
            map.add("price_currency", "USD");
            map.add("receive_currency", "USD");
            map.add("title", "ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            ResponseEntity<String> response = restClient.postForEntity(url, request, String.class);

            JsonParser basicJsonParser = new BasicJsonParser();
            String paymentUrl = (String)basicJsonParser.parseMap(response.getBody()).get("payment_url");
            System.out.println("Izasao -> "+ paymentUrl);
            return new ResponseEntity<String>(paymentUrl, HttpStatus.OK);

        }catch (Exception ex) {

            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
