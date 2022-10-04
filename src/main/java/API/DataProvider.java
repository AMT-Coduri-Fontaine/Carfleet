package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.List;

public interface DataProvider {
    List<Driver> getDrivers();
    List<Car> getCars();
}
