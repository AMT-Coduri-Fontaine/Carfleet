package amt.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void carCreation_WithoutAttributes_Success() {
        final Car car = new Car("id", "name");


        assertEquals("id", car.getId());
        assertEquals("name", car.getName());
        assertEquals(0, car.getAttributes().size());
    }

    @Test
    void carCreation_WithAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Car car = new Car("id", "name", attributes);

        assertEquals("id", car.getId());
        assertEquals("name", car.getName());
        assertEquals(1, car.getAttributes().size());
    }

    @Test
    void attributesLocalModification_DoesntAffectCarAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Car car = new Car("id", "name", attributes);
        attributes.remove(0);

        assertEquals(1, car.getAttributes().size());
    }

    @Test
    void carAttributes_GetAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Car car = new Car("id", "name", attributes);

        assertEquals(attributes, car.getAttributes());
    }

    @Test
    void carAttributes_GetAttributesModification_DoesntAffectCarAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        Attribute attr1 = new Attribute("attr1", "val1");
        attributes.add(attr1);
        final Car car = new Car("id", "name", attributes);
        car.getAttributes().remove(attr1);

        assertEquals(1, car.getAttributes().size());
    }
}