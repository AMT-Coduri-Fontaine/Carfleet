package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.List;

/**
 * Cette class permet de récupérer des fausses données pour pouvoir faire des tests.
 */
public class MockApi implements DataProvider {

    String generateDriverJson(String id, String name, String columnValues) {
        final String driverJson = """
                {
                  "id": "%s",
                  "name": "%s",
                  "column_values": [
                    %s
                  ]
                }
                """;


        return driverJson.formatted(id, name, columnValues);
    }

    String generateCarJson(String id, String name, String columnValues) {
        final String driverJson = """
                {
                  "id": "%s",
                  "name": "%s",
                  "column_values": [
                    %s
                  ]
                }
                """;


        return driverJson.formatted(id, name, columnValues);
    }

    String generateColumnValue(String title, String text){
        final String columnValue = """
                {
                  "title": "%s",
                  "text": "%s"
                }
                """;

        return columnValue.formatted(title, text);
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
