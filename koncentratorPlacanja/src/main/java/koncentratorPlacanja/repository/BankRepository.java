package koncentratorPlacanja.repository;

import koncentratorPlacanja.model.Bank;
import koncentratorPlacanja.model.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByKodBanke (String kodBanke);

}
