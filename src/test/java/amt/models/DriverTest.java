package amt.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void driverCreation_WithoutAttributes_Success() {
        final Driver driver = new Driver("id", "name");


        assertEquals("id", driver.getId());
        assertEquals("name", driver.getName());
        assertEquals(0, driver.getAttributes().size());
    }

    @Test
    void driverCreation_WithAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Driver driver = new Driver("id", "name", attributes, "");

        assertEquals("id", driver.getId());
        assertEquals("name", driver.getName());
        assertEquals(1, driver.getAttributes().size());
    }

    @Test
    void attributesLocalModification_DoesntAffectDriverAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Driver driver = new Driver("id", "name", attributes, "");
        attributes.remove(0);

        assertEquals(1, driver.getAttributes().size());
    }

    @Test
    void driverAttributes_GetAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("attr1", "val1"));
        final Driver driver = new Driver("id", "name", attributes, "");

        assertEquals(attributes, driver.getAttributes());
    }

    @Test
    void driverAttributes_GetAttributesModification_DoesntAffectDriverAttributes_Success() {
        final ArrayList<Attribute> attributes = new ArrayList<>();
        Attribute attr1 = new Attribute("attr1", "val1");
        attributes.add(attr1);
        final Driver driver = new Driver("id", "name", attributes, "");
        driver.getAttributes().remove(attr1);

        assertEquals(1, driver.getAttributes().size());
    }

    @Test
    void driverAttributes_GetEmptyAttributes_ReturnsEmptyList_Success() {
        final Driver driver = new Driver("id", "name");

        assertEquals(new ArrayList<Attribute>(), driver.getAttributes());
        assertEquals(0, driver.getAttributes().size());
    }

    @Test
    void driverId_GetId_Success() {
        final Driver driver = new Driver("id", "name");

        assertEquals("id", driver.getId());
    }

    @Test
    void driverName_GetName_Success() {
        final Driver driver = new Driver("id", "name");

        assertEquals("name", driver.getName());
    }
}