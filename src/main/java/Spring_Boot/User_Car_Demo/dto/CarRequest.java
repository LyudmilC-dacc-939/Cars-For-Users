package Spring_Boot.User_Car_Demo.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {
    @NotNull
    private String brand;
    private String model;
    private String vin;
    @NotNull
    private String regNumber;
}
