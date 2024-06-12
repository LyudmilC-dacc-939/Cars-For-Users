package Spring_Boot.User_Car_Demo.service.Implementation;

import Spring_Boot.User_Car_Demo.converter.CarConverter;
import Spring_Boot.User_Car_Demo.dto.CarRequest;
import Spring_Boot.User_Car_Demo.dto.CarResponse;
import Spring_Boot.User_Car_Demo.model.Car;

import Spring_Boot.User_Car_Demo.repository.CarRepository;
import Spring_Boot.User_Car_Demo.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private CarConverter carConverter;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    @Override
    public CarResponse saveCar(CarRequest carRequest) {
        Car car = carConverter.toCar(carRequest);
        Car savedCar = carRepository.save(car);

        CarResponse carResponse = new CarResponse();

        BeanUtils.copyProperties(savedCar, carResponse);
        return carResponse;

    }

    @Override
    public CarResponse findCarById(Long id) {
        Car car = carRepository.findById(id).orElse(new Car());

        CarResponse carResponse = new CarResponse();
        BeanUtils.copyProperties(car, carResponse);
        return carResponse;
    }

    @Override
    public Car updateCar(CarRequest carRequest, Long carId) {
        Optional<Car> existingCar = carRepository.findById(carId);

        if (existingCar.isEmpty()) {
            log.error(String.format("Car with id %s not exist", carId));
            return new Car();
        }
        Car car = existingCar.get();

        if (carRequest.getModel() != null) {
            car.setModel(carRequest.getModel());
        }
        if (carRequest.getVin() != null) {
            car.setVin(carRequest.getVin());
        }
        car.setBrand(carRequest.getBrand());
        car.setRegNumber(carRequest.getRegNumber());

        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
