package live.mukeshtechlab.quickrideapp.services;

import live.mukeshtechlab.quickrideapp.exceptions.DriverNotFoundException;
import live.mukeshtechlab.quickrideapp.exceptions.VehicleNotFoundException;
import live.mukeshtechlab.quickrideapp.models.Driver;
import live.mukeshtechlab.quickrideapp.models.Ride;
import live.mukeshtechlab.quickrideapp.models.Vehicle;
import live.mukeshtechlab.quickrideapp.repositories.DriverRepository;
import live.mukeshtechlab.quickrideapp.repositories.RideRepository;
import live.mukeshtechlab.quickrideapp.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideService {
    private VehicleRepository vehicleRepository;
    private DriverRepository driverRepository;
    private RideRepository rideRepository;

    public RideService(
            VehicleRepository vehicleRepository,
            DriverRepository driverRepository,
            RideRepository rideRepository
    ){
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    public Ride proposeRide(
            String source,
            String destination,
            Long driverId,
            Long vehicleId,
            int availableSeatCount,
            int amount
    ) throws VehicleNotFoundException, DriverNotFoundException {
        // Check Vehicle is Present id DB or Not
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if(vehicleOptional.isEmpty()){
            // If True = Vehicle is not Present
            throw new VehicleNotFoundException("Vehicle with id: " + vehicleId + " not present in DB.");
        }
        Vehicle vehicle = vehicleOptional.get();

        // Check if the Driver is Present or Not
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if(driverOptional.isEmpty()){
            // If True = Driver is Not Present
            throw new DriverNotFoundException("Driver with id: " + driverId + " not found in DB.");
        }
        Driver driver = driverOptional.get();

        // Create Ride
        Ride ride = new Ride();
        ride.setSource(source);
        ride.setDestination(destination);
        ride.setAmount(amount);
        ride.setAvailableSeatCount(availableSeatCount);
        ride.setDriver(driver);
        ride.setVehicle(vehicle);

        return rideRepository.save(ride);
    }

}
