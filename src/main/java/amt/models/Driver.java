package amt.models;

import java.util.LinkedList;
import java.util.List;

public class Driver extends Entity{
    private String carId;
    public Driver(String id, String name, List<Attribute> attributes, String carId) {
        super(id, name, attributes);
        this.carId = carId;
    }

    public Driver(String id, String name) {
        super(id, name, null);
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
