package live.mukeshtechlab.quickrideapp;

import live.mukeshtechlab.quickrideapp.models.Driver;
import live.mukeshtechlab.quickrideapp.models.UserType;
import live.mukeshtechlab.quickrideapp.models.Vehicle;
import live.mukeshtechlab.quickrideapp.models.VehicleType;
import live.mukeshtechlab.quickrideapp.repositories.DriverRepository;
import live.mukeshtechlab.quickrideapp.repositories.VehicleRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class AddData {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    @Order(2)
    public void addDriverData(){
        Driver driver = new Driver();
        driver.setName("John Doe");
        driver.setEmail("JohnDoe@Example.com");
        driver.setPassword("password");
        driver.setRating(9.0);
        driver.setGender("male");
        driver.setUserType(UserType.DRIVER);
        driver.setRides(new ArrayList<>());

        driver.setVehicles(new ArrayList<>());
        Vehicle vehicle1 = vehicleRepository.findById(1L).orElse(null);
        driver.getVehicles().add(vehicle1);

        driverRepository.save(driver);
    }

    @Test
    @Order(1)
    public void addVehicleData(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Car");
        vehicle.setNumber("AB12CD3456");
        vehicle.setSeatCount(4);
        vehicle.setVehicleType(VehicleType.SEDEN);
        vehicle.setDriver(driverRepository.findById(1L).orElse(null));
        vehicleRepository.save(vehicle);
    }

}
