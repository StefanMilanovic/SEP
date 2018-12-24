package bankaProdavca.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/primiPodatke")
public class primiPodatkeController {

    private BankData tempData

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


}
