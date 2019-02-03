package PCC.controller;

import PCC.model.Bank;
import PCC.model.BankResponse;
import PCC.model.TransactionData;
import PCC.service.BankService;
import PCC.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("usmeravanje")
public class UsmeravanjeController {

    @Autowired
    private TransactionDataService transactionDataService;

    @Autowired
    private BankService bankService;

    @RequestMapping(
            value = "/prihvatiPodatke",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BankResponse> preusmeri(@RequestBody TransactionData data){

        transactionDataService.saveOne(data);

        Bank bank = bankService.findByKod(data.getBankCodeIssuer());
        BankResponse response = new BankResponse(data, bank);

        return new ResponseEntity<BankResponse>(response, HttpStatus.OK);
    }
}
