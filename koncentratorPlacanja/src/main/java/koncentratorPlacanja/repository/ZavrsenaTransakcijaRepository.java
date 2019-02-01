package koncentratorPlacanja.repository;

import koncentratorPlacanja.model.ZavrsenaTransakcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZavrsenaTransakcijaRepository extends JpaRepository<ZavrsenaTransakcija, Long> {
}
