package koncentratorPlacanja.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import koncentratorPlacanja.model.Klijent;
import koncentratorPlacanja.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/klijent")
public class KlijentController {
    @Autowired
    private KlijentService klijentService;



    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> getUser(@PathVariable("id") Long id) {
        Klijent listaAdminaFanZone = klijentService.findOne(id);
        return new ResponseEntity<>(listaAdminaFanZone, HttpStatus.OK);     // "200 OK"
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<?> CreateUser(@Validated @RequestBody Klijent user, Errors errors) {

        if (errors.hasErrors()) {
            return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        Klijent userNew = klijentService.save(user);
        return new ResponseEntity(userNew, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> azuriraj(@PathVariable("id") Long id) {
        Klijent listaAdminaFanZone = klijentService.findOne(id);
        return new ResponseEntity(listaAdminaFanZone, HttpStatus.OK);     // "200 OK"
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Klijent> izbrisi(@PathVariable("id") Long id) {

        klijentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUsers() {
        List<Klijent> listaAdminaFanZone = klijentService.findAll();
        return new ResponseEntity<>(listaAdminaFanZone, HttpStatus.OK);     // "200 OK"
    }

    @RequestMapping(
            value="/registruj",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> registrujKlijenta(@RequestBody Klijent data){
        Klijent noviKlijent = new Klijent(data.getImeKompanije(), data.getEmail(), data.getPassword(), data.getBankId(),
                data.getBankPass(), data.getSuccessUrl(), data.getFailedUrl(), data.getErrorUrl(), data.getPaypalSecret(),
                data.getBitcoinSecret(), data.isPaypalEnabled(), data.isBitcoinEnabled(), data.isBankEnabled());
        klijentService.save(noviKlijent);
        return new ResponseEntity<Klijent>(noviKlijent, HttpStatus.OK);
    }

    @RequestMapping(
            value="/ulogojKlijenta",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Boolean ulogujKlijenta(@RequestBody Klijent data){
        Klijent ulogovanKlijent = klijentService.findByemail(data.getEmail());
        if(ulogovanKlijent == null){
            return null;
        }
        else if(ulogovanKlijent.getPassword().equals(data.getPassword())){
            return true;
        }
        return false;
    }

    @RequestMapping(
            value="/nadjiKlijenta",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> nadjiKlijenta(@RequestBody  String email){
        return new ResponseEntity<Klijent>(klijentService.findByemail(email), HttpStatus.OK );
    }

    @RequestMapping(
            value="/izmeniKlijenta",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Klijent> izmeniKlijenta(@RequestBody Klijent data){
        Klijent menjaniKlijent = klijentService.findByemail(data.getEmail());
        menjaniKlijent.setPaypalEnabled(data.isPaypalEnabled());
        menjaniKlijent.setBitcoinEnabled(data.isBitcoinEnabled());
        menjaniKlijent.setBankEnabled(data.isBankEnabled());
        menjaniKlijent.setBankId(data.getBankId());
        menjaniKlijent.setBankPass(data.getBankPass());
        menjaniKlijent.setPaypalSecret(data.getPaypalSecret());
        menjaniKlijent.setBitcoinSecret(data.getBitcoinSecret());
        menjaniKlijent.setErrorUrl(data.getErrorUrl());
        menjaniKlijent.setSuccessUrl(data.getSuccessUrl());
        menjaniKlijent.setFailedUrl(data.getFailedUrl());

        klijentService.save(menjaniKlijent);
        return new ResponseEntity<Klijent>(menjaniKlijent, HttpStatus.OK);
    }

}
