package Spring_Boot.User_Car_Demo.controller;

import Spring_Boot.User_Car_Demo.dto.CarRequest;
import Spring_Boot.User_Car_Demo.dto.CarResponse;
import Spring_Boot.User_Car_Demo.model.Car;
import Spring_Boot.User_Car_Demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-car-demo/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "/create-car")
    ResponseEntity<CarResponse> createCar(@RequestBody CarRequest carRequest) {
        carService.saveCar(carRequest);

        return new ResponseEntity<>(carService.saveCar(carRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{carId}")
    ResponseEntity<CarResponse> readById(@PathVariable("carId") Long id) {
        return new ResponseEntity<>(carService.findCarById(id), HttpStatus.FOUND);
    }

    @PutMapping(path = "/{carId}")
    Car updateCar(@RequestBody CarRequest carRequest,
                  @PathVariable("carId") Long id) {
        return carService.updateCar(carRequest, id);
    }

    @DeleteMapping(path = "/{carId}")
    void deleteCar(@PathVariable("carId") Long id) {
        carService.deleteCarById(id);
    }


}
