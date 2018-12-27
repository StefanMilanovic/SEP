package bankaProdavca.repository;

import bankaProdavca.model.BankKlijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankKlijentRepository extends JpaRepository<BankKlijent, Long> {
    BankKlijent findByKlijentId(String id);
}
