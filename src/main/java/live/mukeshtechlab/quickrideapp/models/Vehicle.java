package live.mukeshtechlab.quickrideapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel {
    private String name;
    private String number;
    private int seatCount;

    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;

    @ManyToOne
    private Driver driver;
}
