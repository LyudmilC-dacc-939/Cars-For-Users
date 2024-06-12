package Spring_Boot.User_Car_Demo.service;

import Spring_Boot.User_Car_Demo.dto.CarRequest;
import Spring_Boot.User_Car_Demo.dto.CarResponse;
import Spring_Boot.User_Car_Demo.model.Car;

public interface CarService {

    CarResponse saveCar(CarRequest carRequest);

    CarResponse findCarById(Long id);

    Car updateCar(CarRequest carRequest, Long carId);

    void deleteCarById(Long id);

}
