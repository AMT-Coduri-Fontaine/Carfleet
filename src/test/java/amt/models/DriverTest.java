package amt.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        assertTrue(driver.getId().equals("id"));
        assertTrue(driver.getName().equals("name"));
    }
}