package Spring_Boot.User_Car_Demo.dto;

import lombok.Data;

@Data
public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String vin;
    private String regNumber;
}
