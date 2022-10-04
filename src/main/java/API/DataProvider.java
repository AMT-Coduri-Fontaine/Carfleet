package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.List;

public abstract class DataProvider {
    List<Driver> getDrivers(){
        return null;
    }
    List<Car> getCars(){
        return null;
    }

    protected abstract String fetchDrivers();
    protected abstract String fetchCars();
}
