package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.List;

/**
 * Cette class permet de récupérer des fausses données pour pouvoir faire des tests.
 */
public class MockApi implements DataProvider {

    String generateDriverJson(String id, String name, String columnValues) {
        return "";
    }

    String generateCarJson(String id, String name, String columnValues) {
        return "";
    }

    String generateColumnValue(String title, String text){
        return "";
    }

    @Override
    public List<Driver> getDrivers() {
        return null;
    }

    @Override
    public List<Car> getCars() {
        return null;
    }
}
