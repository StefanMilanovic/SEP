package bankaProdavca.controller;

import bankaProdavca.model.BankData;
import bankaProdavca.repository.BankDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/primiPodatke")
public class primiPodatkeController {

    @Autowired
    private BankDataRepository bankDataRepository;

    @RequestMapping(
            value = "/primi",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BankData> preuzmiPodatke(@RequestBody @Valid BankData data) {

        BankData noviData = new BankData(data.getProdavac_bank_id(), data.getProdavac_bank_lozinka(), data.getSuccess_url(), data.getFailed_url(),
            data.getError_url(), data.getKolicina(), data.getProdavac_vreme_transakcije(), data.getToken(), data.getBankRacunProdavac());
        bankDataRepository.save(noviData);

        return new ResponseEntity<BankData>(data, HttpStatus.OK);
    }
}
