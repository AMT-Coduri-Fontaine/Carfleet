package API;

import amt.models.Car;
import amt.models.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderTest {
    final DataProvider api;

    DataProviderTest(){
        api = new MockApi(10);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDrivers() {
        final List<Driver> result = api.getDrivers();

        assertNotEquals(0, result.size());

        for (final Driver driver : result) {
            assertNotNull(driver.getId());
            assertNotNull(driver.getName());
            assertNotNull(driver.getAttributes());
        }
    }

    @Test
    void getCars() {
        final List<Car> result = api.getCars();

        assertNotEquals(0, result.size());

        for (final Car car : result) {

            assertNotNull(car.getId());
            assertNotNull(car.getName());
            assertNotNull(car.getAttributes());
        }
    }
}