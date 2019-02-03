package bankaProdavca.controller;

import bankaProdavca.model.BankData;
import bankaProdavca.model.ResultData;
import bankaProdavca.service.BankDataService;
import bankaProdavca.service.KarticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bankPccController")
public class PccController {

    @Autowired
    private BankDataService bankDataService;

    @Autowired
    private KarticaService karticaService;

    @RequestMapping(
            value = "/zavrsiPccTransakciju",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResultData> obradiPccTransakciju(@RequestBody BankData data){
        BankData bankData = bankDataService.findByToken(data.getToken());
        bankDataService.save(bankData);

        ResultData resultData = new ResultData(bankData.getToken(), bankData.getResult(), bankData);
        return new ResponseEntity<ResultData>(resultData, HttpStatus.OK);
    }
}
