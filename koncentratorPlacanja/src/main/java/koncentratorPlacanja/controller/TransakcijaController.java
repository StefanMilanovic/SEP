package koncentratorPlacanja.controller;


import koncentratorPlacanja.DTO.BitcoinDTO;
import koncentratorPlacanja.DTO.BitcoinResponseDTO;
import koncentratorPlacanja.model.BankData;
import koncentratorPlacanja.model.NaucnaCentralaData;
import koncentratorPlacanja.model.Transakcija;
import koncentratorPlacanja.model.ZavrsenaTransakcija;
import koncentratorPlacanja.service.KlijentService;
import koncentratorPlacanja.service.TransakcijaService;
import koncentratorPlacanja.service.ZavrsenaTransakcijaService;
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
            value = "/kriptovaluta",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public ResponseEntity<?> kriptovaluta(@RequestBody BitcoinDTO bitcoinDTO) {
        System.out.println("\nBitcoin...");

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("order_id", UUID.randomUUID().toString());
        map.put("price_amount",bitcoinDTO.getKolicina() + "");
        map.put("price_currency","USD");
        map.put("receive_currency","USD");
        map.put("title",bitcoinDTO.getNaziv() + "");
        map.put("description","desc");
        map.put("callback_url","https://api-sandbox.coingate.com/account/orders");// https://api-sandbox.coingate.com/account/orders
        map.put("success_url", "http://localhost:4200/kriptovaluta/success");

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Token ESQ92WMKo9NWCWzYJWdGxu1sQTSwdexkUbz9KJSG");

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

        Transakcija t = new Transakcija(naucnaCentralaData.getKolicina(), klijentService.findByBankId(naucnaCentralaData.getProdavacBankId()),
                naucnaCentralaData.getDatum(), naucnaCentralaData.getBankRacunProdavca());
        transakcijaService.save(t);

        return new ResponseEntity<Transakcija>(HttpStatus.OK);
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
            value = "resultTransakcija/{token}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ZavrsenaTransakcija> resultTransaction(@PathVariable String token, @RequestBody @Valid String result) {

        Transakcija tempTransakcija = transakcijaService.findByToken(token);
        if(tempTransakcija != null) {
            ZavrsenaTransakcija zavrsenaTransakcija = new ZavrsenaTransakcija(tempTransakcija.getToken(), tempTransakcija.getKolicina(),
                    tempTransakcija.getKlijent_id(), tempTransakcija.getBankRacunProdavac(), result);

            zavrsenaTransakcijaService.save(zavrsenaTransakcija);
            transakcijaService.delete(tempTransakcija);

            return new ResponseEntity<ZavrsenaTransakcija>(zavrsenaTransakcija, HttpStatus.OK);
        }
        else{
            return null;
        }
    }

}
