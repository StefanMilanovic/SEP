package koncentratorPlacanja.repository;

import koncentratorPlacanja.model.Transakcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransakcijaRepository extends JpaRepository<Transakcija, Long> {
    Transakcija findById(Long id);
    Transakcija findByToken(String token);

}
