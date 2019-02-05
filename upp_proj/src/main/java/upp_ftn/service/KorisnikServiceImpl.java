package upp_ftn.service;

import org.springframework.stereotype.Service;

import upp_ftn.model.Korisnik;
import upp_ftn.model.KorisnikStatus;
import upp_ftn.model.KorisnikType;
import upp_ftn.repository.KorisnikRepository;

@Service
public class KorisnikServiceImpl implements KorisnikService{

	private KorisnikRepository korisnikRepository;
	
	public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
		this.korisnikRepository = korisnikRepository;
	}

//	@Override														????
	public Korisnik findByUsername(Korisnik korisnik) {
		Korisnik k = this.korisnikRepository.findByUsername(korisnik.getUsername());
		if (k == null) return null;
		
		if (k.getLozinka().equals(korisnik.getLozinka())) {
			return k;
		} else {
			return null;
		}
		
	}

//	@Override
	public boolean register(Korisnik korisnik) {
		korisnik.setKorisnikType(KorisnikType.USER);
		korisnik.setKorisnikStatus(KorisnikStatus.ACTIVATED);			// change!
		Korisnik k = this.korisnikRepository.save(korisnik);
		if (k != null) {
			return true;
		}
		return false;
	
	}
/*
	@Override
	public List<Korisnik> getNotAcctivated() {
		return this.korisnikRepository.findByUserStatusAndUserType(KorisnikStatus.PENDING, KorisnikType.USER);
	}

	@Override
	public boolean setStatus(String id, KorisnikStatus korisnikStatus) {
		Optional<Korisnik> k = this.korisnikRepository.findById(Long.parseLong(id));
		if (k.isPresent()) {
			Korisnik korisnik = k.get();
			korisnik.setKorisnikStatus(korisnikStatus);
			this.korisnikRepository.save(korisnik);
			return true;
		}
		return false;
	}
	*/
}
