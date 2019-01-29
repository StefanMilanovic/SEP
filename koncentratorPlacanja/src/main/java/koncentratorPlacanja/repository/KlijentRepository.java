package koncentratorPlacanja.repository;

import koncentratorPlacanja.model.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KlijentRepository extends JpaRepository<Klijent, Long> {
    Klijent findBybankId(String id);
    Klijent findByemail (String email);
}
