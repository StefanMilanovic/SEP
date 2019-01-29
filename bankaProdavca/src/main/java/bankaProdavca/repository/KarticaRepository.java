package bankaProdavca.repository;

import bankaProdavca.model.Kartica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KarticaRepository extends JpaRepository<Kartica, Long> {
    Kartica findById(Long id);
    Kartica findByBrojKartice(String brojKartice);

}
