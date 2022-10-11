package amt.models;

import java.util.LinkedList;
import java.util.List;

public class Entity {
    protected final String id;
    protected final String name;
    protected final List<Attribute> attributes = new LinkedList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return new LinkedList<>(attributes);
    }

    public Entity(String id, String name, List<Attribute> attributes) {
        this.id = id;
        this.name = name;
        if (attributes != null)
            this.attributes.addAll(attributes);
    }
}
