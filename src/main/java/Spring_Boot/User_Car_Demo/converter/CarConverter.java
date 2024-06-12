package Spring_Boot.User_Car_Demo.converter;

import Spring_Boot.User_Car_Demo.dto.CarRequest;
import Spring_Boot.User_Car_Demo.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car toCar(CarRequest carRequest){

        Car car = new Car();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setVin(carRequest.getVin());
        car.setRegNumber(carRequest.getRegNumber());
        return car;

    }
}
