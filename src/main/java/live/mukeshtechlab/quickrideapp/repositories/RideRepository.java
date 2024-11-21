package live.mukeshtechlab.quickrideapp.repositories;

import live.mukeshtechlab.quickrideapp.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
