package live.mukeshtechlab.quickrideapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposeRideRequestDto {
    private String source;
    private String destination;
    private Long driverId;
    private Long vehicleId;
    private int availableSeatCount;
    private int amount;
}
