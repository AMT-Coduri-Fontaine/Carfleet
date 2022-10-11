package amt.models;

import java.util.LinkedList;
import java.util.List;

public class Driver {
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

    public Driver(String id, String name, List<Attribute> attributes) {
        this(id, name);
        if (attributes != null)
            this.attributes.addAll(attributes);
    }

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
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
