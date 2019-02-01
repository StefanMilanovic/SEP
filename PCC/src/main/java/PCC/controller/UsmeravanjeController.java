package PCC.controller;

import PCC.model.TransactionData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("usmeravanje")
public class UsmeravanjeController {


    @RequestMapping(
            value = "/prihvatiPodatke",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransactionData> preusmeri(){
        return null;
    }
}
