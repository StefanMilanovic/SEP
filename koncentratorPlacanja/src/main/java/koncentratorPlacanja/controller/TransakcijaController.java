package koncentratorPlacanja.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transakcija")
public class TransakcijaController {


    @RequestMapping(
            value = "/kriptovaluta",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUser() {
        System.out.println("\nTransakcija kontroler \n");
        return new ResponseEntity<>("Transakcija kontroler", HttpStatus.OK);     // "200 OK"
    }



}
