package API;

import amt.models.Attribute;
import amt.models.Car;
import amt.models.Driver;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;

public abstract class DataProvider {
    private ObjectMapper objectMapper = new ObjectMapper();

    public class JsonFormatException extends RuntimeException {
        public JsonFormatException() {
            super("Wrong JSON format");
        }
    }

    List<Driver> getDrivers(){
        String json = fetchDrivers();
        final List<Driver> drivers = new LinkedList<>();
        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            for(final JsonNode carNode : jsonNode){
                final String carId = carNode.get("id").asText();
                // final String plate = carNode.get("name").asText();
                final JsonNode subitems = carNode.get("subitems");

                for(final JsonNode driverNode: subitems){
                    final String driverId = driverNode.get("id").asText();
                    final String driverName = driverNode.get("name").asText();
                    final JsonNode columnValues = driverNode.get("column_values");
                    final List<Attribute> attributes = new LinkedList<>();

                    for(final JsonNode attributeNode: columnValues){
                        final String title = attributeNode.get("title").asText();
                        final String text = attributeNode.get("text").asText();
                        attributes.add(new Attribute(title, text));
                    }

                    // It should contain only one element
                    drivers.add(new Driver(driverId, driverName, attributes, carId));
                    break;
                }
            }


            return drivers;
        }catch(Exception e){
            e.printStackTrace();
            throw new JsonFormatException();
        }
    }
    List<Car> getCars(){
        String json = fetchCars();
        final List<Car> cars = new LinkedList<>();
        try{
            JsonNode jsonNode = objectMapper.readTree(json);

            for(final JsonNode carNode : jsonNode){
                final String carId = carNode.get("id").asText();
                final String plate = carNode.get("name").asText();
                final JsonNode columnValues = carNode.get("column_values");
                final List<Attribute> attributes = new LinkedList<>();

                for(final JsonNode attributeNode: columnValues){
                    final String title = attributeNode.get("title").asText();
                    final String text = attributeNode.get("text").asText();
                    attributes.add(new Attribute(title, text));
                }

                cars.add(new Car(carId, plate, attributes));
            }

            return cars;
        }catch(Exception e){
            e.printStackTrace();
            throw new JsonFormatException();
        }
    }

    protected abstract String fetchDrivers();
    protected abstract String fetchCars();
}
