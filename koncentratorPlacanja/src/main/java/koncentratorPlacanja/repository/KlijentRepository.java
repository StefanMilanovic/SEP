package koncentratorPlacanja.repository;

import koncentratorPlacanja.model.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KlijentRepository extends JpaRepository<Klijent, Long> {
   // @Query("SELECT * from klijent where klijent.prodavac_bank_id = ")
    Klijent findByprodavacBankId(String id);
}
