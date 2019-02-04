package upp_ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp_ftn.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	Korisnik findByUsername(String username);
//	List<Korisnik> findByUserStatusAndUserType(KorisnikStatus korisnikStatus, KorisnikType korisnikType);
}
