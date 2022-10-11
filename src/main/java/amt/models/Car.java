package amt.models;

import org.w3c.dom.Attr;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Car extends Entity{
    private Driver driver;

    public Car(String id, String name, List<Attribute> attributes){
        super(id, name, attributes);
    }

    public Car(String id, String name) {
        super(id, name, null);
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                ", driver=" + driver +
                '}';
    }
}
