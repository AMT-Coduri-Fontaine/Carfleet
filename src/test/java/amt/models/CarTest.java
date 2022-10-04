package amt.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCar(){
        final Car car = new Car("id", "name", new HashMap<>());

        assertEquals("id", car.getId());
        assertEquals("name", car.getName());
        assertEquals(0, car.getAttributes().size());
    }
}