package live.mukeshtechlab.quickrideapp.controllers;

import live.mukeshtechlab.quickrideapp.dtos.ProposeRideRequestDto;
import live.mukeshtechlab.quickrideapp.dtos.ProposeRideResponseDto;
import live.mukeshtechlab.quickrideapp.exceptions.DriverNotFoundException;
import live.mukeshtechlab.quickrideapp.exceptions.VehicleNotFoundException;
import live.mukeshtechlab.quickrideapp.models.Ride;
import live.mukeshtechlab.quickrideapp.services.RideService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;
    public RideController(RideService rideService){
        this.rideService = rideService;
    }

    @PostMapping()
    public ProposeRideResponseDto proposeRide(@RequestBody ProposeRideRequestDto proposeRideRequestDto) throws VehicleNotFoundException, DriverNotFoundException {
        ProposeRideResponseDto proposeRideResponseDto = new ProposeRideResponseDto();
        Ride ride = rideService.proposeRide(
                proposeRideRequestDto.getSource(),
                proposeRideRequestDto.getDestination(),
                proposeRideRequestDto.getDriverId(),
                proposeRideRequestDto.getVehicleId(),
                proposeRideRequestDto.getAvailableSeatCount(),
                proposeRideRequestDto.getAmount()
        );
        proposeRideResponseDto.setSource(ride.getSource());
        proposeRideResponseDto.setDestination(ride.getDestination());
        proposeRideResponseDto.setDriverName(ride.getDriver().getName());
        proposeRideResponseDto.setVehicleName(ride.getVehicle().getName());
        proposeRideResponseDto.setAvailableSeatCount(ride.getAvailableSeatCount());
        proposeRideResponseDto.setAmount(ride.getAmount());
        return proposeRideResponseDto;
    }
}
