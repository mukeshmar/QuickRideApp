package live.mukeshtechlab.quickrideapp.dtos;

import live.mukeshtechlab.quickrideapp.models.Driver;
import live.mukeshtechlab.quickrideapp.models.Ride;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposeRideResponseDto {
    private String source;
    private String destination;
    private String driverName;
    private String vehicleName;
    private int availableSeatCount;
    private int amount;
}
