package bankaKupca;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/city")
public class TestController {

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>("Test banka kupca", HttpStatus.OK);     // "200 OK"
    }


}
