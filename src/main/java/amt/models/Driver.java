package amt.models;

import java.util.Map;

public class Driver {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    private final String id;
    private final String name;
    private final Map<String, String> attributes;

    Driver(String id, String name, Map<String, String> attributes){
        this.id = id;
        this.name = name;
        this.attributes = attributes;
    }
}
