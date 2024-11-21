package live.mukeshtechlab.quickrideapp.repositories;

import live.mukeshtechlab.quickrideapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
