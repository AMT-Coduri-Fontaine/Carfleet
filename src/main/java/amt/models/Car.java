package amt.models;

import org.w3c.dom.Attr;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Car {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return new LinkedList<>(attributes);
    }

    private final String id;
    private final String name;
    private final List<Attribute> attributes = new LinkedList<>();

    public Car(String id, String name, List<Attribute> attributes){
        this.id = id;
        this.name = name;
        if (attributes != null)
            this.attributes.addAll(attributes);
    }

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
