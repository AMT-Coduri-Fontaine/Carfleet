package amt.models;

import java.util.LinkedList;
import java.util.List;

public class Driver extends Entity{

    public Driver(String id, String name, List<Attribute> attributes) {
        super(id, name, attributes);
    }

    public Driver(String id, String name) {
        super(id, name, null);
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
