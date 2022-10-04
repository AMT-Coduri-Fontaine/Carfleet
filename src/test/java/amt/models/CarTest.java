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

    @Test
    void carAttributes_GetEmptyAttributes_ReturnsEmptyList_Success() {
        final Car car = new Car("id", "name");

        assertEquals(new ArrayList<Attribute>(), car.getAttributes());
        assertEquals(0, car.getAttributes().size());
    }

    @Test
    void carId_GetId_Success() {
        final Car car = new Car("id", "name");

        assertEquals("id", car.getId());
    }

    @Test
    void carName_GetName_Success() {
        final Car car = new Car("id", "name");

        assertEquals("name", car.getName());
    }

    @Test
    void carDriver_SetDriver_Success() {
        final Car car = new Car("id", "name");
        final Driver driver = new Driver("id2", "name2");
        car.setDriver(driver);

        assertEquals(driver, car.getDriver());
    }

    @Test
    void carDriver_SetNull_Success() {
        final Car car = new Car("id", "name");
        car.setDriver(null);

        assertEquals(null, car.getDriver());
    }
}