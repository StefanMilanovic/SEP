package bankaProdavca.controller;

import bankaProdavca.model.BankData;
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



    @RequestMapping(
            value = "/primi",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BankData> preuzmiPodatke(@RequestBody @Valid BankData data) {

        BankData newData = data;

        return  null;
    }


}
