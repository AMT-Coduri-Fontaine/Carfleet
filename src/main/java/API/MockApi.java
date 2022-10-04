package API;


import java.util.Arrays;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Cette class permet de récupérer des fausses données pour pouvoir faire des tests.
 */
public class MockApi extends DataProvider {
    private static final Random random = new Random();
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

    static MockData[] generateRandomData(){
        MockApi.MockData[] datas = new MockApi.MockData[random.nextInt(0,21)];
        for(int i = 0; i < datas.length; i++){
            MockApi.ColumnValue[] columnValues = new MockApi.ColumnValue[random.nextInt(0,21)];
            for(int j = 0; j < columnValues.length; j++){
                columnValues[j] = new MockApi.ColumnValue(generateRandomString(), generateRandomString());
            }
            datas[i] = new MockApi.MockData(generateRandomString(), generateRandomString(), columnValues);
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
        return "[" + Arrays.stream(datas).map(MockData::toJson).collect(Collectors.joining(",")) + "]";
    }

    @Override
    protected String fetchCars() {
        return "[" + Arrays.stream(datas).map(MockData::toJson).collect(Collectors.joining(",")) + "]";
    }
}
