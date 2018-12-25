package bankaProdavca.repository;

import bankaProdavca.model.BankData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDataRepository extends JpaRepository<BankData, Long> {
    BankData findByToken(String token);
}
