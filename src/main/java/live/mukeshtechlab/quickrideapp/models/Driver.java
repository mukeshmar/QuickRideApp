package live.mukeshtechlab.quickrideapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Driver extends User {
    @OneToMany(mappedBy = "driver")
    private List<Ride> rides;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles;
}
