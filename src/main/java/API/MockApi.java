package API;


import java.util.Arrays;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Cette class permet de récupérer des fausses données pour pouvoir faire des tests.
 */
public class MockApi extends DataProvider {
    private static final Random random = new Random();
    private final MockEntry[] drivers;
    private final MockEntry[] cars;
    public MockApi(int numberOfCars){
        this.cars = MockApi.generateRandomData(numberOfCars, 3);
        this.drivers = MockApi.generateRandomData(numberOfCars, 3);
    }
    public record MockEntry(String id, String name, ColumnValue[] columnValues) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MockEntry mockEntry = (MockEntry) o;

            if (!id.equals(mockEntry.id)) return false;
            if (!name.equals(mockEntry.name)) return false;
            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(columnValues, mockEntry.columnValues);
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

    static MockEntry[] generateRandomData(int numberOfEntry, int numberOfColumnValue){
        MockEntry[] datas = new MockEntry[numberOfEntry];
        for(int i = 0; i < datas.length; i++){
            MockApi.ColumnValue[] columnValues = new MockApi.ColumnValue[numberOfColumnValue];
            for(int j = 0; j < columnValues.length; j++){
                columnValues[j] = new MockApi.ColumnValue(generateRandomString(), generateRandomString());
            }
            datas[i] = new MockEntry(generateRandomString(), generateRandomString(), columnValues);
        }
        return datas;
    }

    /**
     * source: https://www.baeldung.com/java-random-string
     */
    private static String generateRandomString(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = random.nextInt(0,16);


        return  random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    protected String fetchDrivers() {
        final String driversJson = """
                {
                  "id": "%s",
                  "name": "%s",
                  "subitems": [
                    %s
                  ]
                }
                """;

        final String[] driversJsons = Arrays.stream(drivers).map(MockEntry::toJson).toArray(String[]::new);
        final String[] result = new String[driversJsons.length];

        for (int i = 0; i < cars.length; i++) {
            final MockEntry car = cars[i];
            result[i] = driversJson.formatted(car.id, car.name, driversJsons[i]);
        }

        return "[" + String.join(",", result) + "]";
    }

    @Override
    protected String fetchCars() {
        return "[" + Arrays.stream(cars).map(MockEntry::toJson).collect(Collectors.joining(",")) + "]";
    }
}
