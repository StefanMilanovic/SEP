package upp_ftn.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import upp_ftn.model.Korisnik;
import upp_ftn.model.KorisnikStatus;
import upp_ftn.model.KorisnikType;
import upp_ftn.service.KorisnikService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class KorisnikController {
	
	private static final Logger logger = LoggerFactory.getLogger(KorisnikController.class);
	
	private KorisnikService korisnikService;
	
	public KorisnikController(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody Korisnik korisnik, HttpServletRequest request,  @RequestParam String u) {
		System.out.println("Over here!");
		logger.debug("REST request to login into system!");
		Korisnik k = this.korisnikService.findByUsername(korisnik);
		if (k != null && k.getKorisnikStatus() == KorisnikStatus.ACTIVATED) {
			System.out.println(u + " aaaaaaaaaa22222222222222222222222222222");
			
			if (k.getKorisnikType() == KorisnikType.USER && u.equals("user")) {
				//System.out.println("FSAFSAFFSA sf af safsa  faf saf sfa");
				request.getSession().setAttribute("user", k);
				return new ResponseEntity<>(HttpStatus.OK);
			} else if (k.getKorisnikType() == KorisnikType.ADMIN && u.equals("admin")) {
				request.getSession().setAttribute("admin", k);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else if (k != null && k.getKorisnikStatus() == KorisnikStatus.PENDING){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
/*	
	@GetMapping("/logout")
	public ResponseEntity logout(HttpServletRequest request, @RequestParam String u) {
		logger.debug("REST request to logout from the system!");
		if(u.equals("admin")) {
			request.getSession().removeAttribute("admin");
		}else if (u.equals("user")) {
			request.getSession().removeAttribute("user");
		}
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
*/	
	@GetMapping("/account")
	public ResponseEntity<Korisnik> account(HttpServletRequest request, @RequestParam String u) {
		logger.debug("REST request to get account data!");
		System.out.println("Here I aaaaaaaaaaaaam");
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		Korisnik admin = (Korisnik) request.getSession().getAttribute("admin");
		if (korisnik != null && u.equals("user")) {
			return new ResponseEntity<>(korisnik, HttpStatus.OK);
		} else if (admin != null && u.equals("admin")) {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody Korisnik k, HttpServletRequest request) {
		logger.debug("REST request to get register user!");
		boolean b = this.korisnikService.register(k);
		if (b) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
