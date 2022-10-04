package API;

import amt.models.Car;
import amt.models.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cette class permet de récupérer des fausses données pour pouvoir faire des tests.
 */
public class MockApi implements DataProvider {
    private final MockData[] datas;
    public MockApi(MockData[] data){
        this.datas = data;
    }
    public record MockData(String id, String name, ColumnValue[] columnValues) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MockData mockData = (MockData) o;

            if (!id.equals(mockData.id)) return false;
            if (!name.equals(mockData.name)) return false;
            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(columnValues, mockData.columnValues);
        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + name.hashCode();
            result = 31 * result + Arrays.hashCode(columnValues);
            return result;
        }

        @Override
        public String toString() {
            return "MockData{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", columnValues=" + Arrays.toString(columnValues) +
                    '}';
        }

        public String toJson(){
            final String json = Arrays.stream(columnValues).map(ColumnValue::toJson).collect(Collectors.joining(","));
            return generateMockJson(id, name, json);
        }
    }

    public record ColumnValue(String title, String text) {
        public String toJson(){
            return generateColumnValue(title, text);
        }
    }

    static String generateMockJson(String id, String name, String columnValues) {
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

    static String generateColumnValue(String title, String text){
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
