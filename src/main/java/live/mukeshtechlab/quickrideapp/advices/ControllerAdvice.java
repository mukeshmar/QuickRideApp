package live.mukeshtechlab.quickrideapp.advices;

import live.mukeshtechlab.quickrideapp.dtos.ErrorDto;
import live.mukeshtechlab.quickrideapp.exceptions.DriverNotFoundException;
import live.mukeshtechlab.quickrideapp.exceptions.VehicleNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ErrorDto handleVehicleNotFoundException(VehicleNotFoundException vehicleNotFoundException){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(vehicleNotFoundException.getMessage());
        return errorDto;
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ErrorDto handleDriverNotFoundException(DriverNotFoundException driverNotFoundException){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(driverNotFoundException.getMessage());
        return errorDto;
    }

}
