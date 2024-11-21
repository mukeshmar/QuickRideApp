package live.mukeshtechlab.quickrideapp.repositories;

import live.mukeshtechlab.quickrideapp.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
