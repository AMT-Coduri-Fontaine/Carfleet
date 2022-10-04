package amt.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Driver {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    private final String id;
    private final String name;
    private final List<Attribute> attributes = new LinkedList<>();

    public Driver(String id, String name, List<Attribute> attributes){
        this.id = id;
        this.name = name;
    }

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
