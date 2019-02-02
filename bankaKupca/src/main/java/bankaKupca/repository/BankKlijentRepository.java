package bankaKupca.repository;

import bankaKupca.model.BankKlijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankKlijentRepository extends JpaRepository<BankKlijent, Long> {
    BankKlijent findByKlijentId(String id);
    BankKlijent findById(Long id);
}
