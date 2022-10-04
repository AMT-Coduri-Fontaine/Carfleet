package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.List;

public abstract class DataProvider {
    List<Driver> getDrivers(){
        String json = fetchDrivers();
        // TODO convert json to object
        return null;
    }
    List<Car> getCars(){
        String json = fetchCars();
        // TODO convert json to object
        return null;
    }

    protected abstract String fetchDrivers();
    protected abstract String fetchCars();
}
