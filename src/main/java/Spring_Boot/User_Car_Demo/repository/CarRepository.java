package Spring_Boot.User_Car_Demo.repository;

import Spring_Boot.User_Car_Demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
