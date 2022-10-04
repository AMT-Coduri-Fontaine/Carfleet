package amt.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void createDriver(){
        final Driver driver = new Driver("id", "name");

        assertEquals("id", driver.getId());
        assertEquals("name", driver.getName());
        assertEquals( 0, driver.getAttributes().size());
    }
}