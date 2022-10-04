package API;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MockApiTest {
    ObjectMapper mapper = new ObjectMapper();
    static MockApi mockApi;

    MockApiTest(){

    }

    @BeforeAll
    static void setUp() {
        mockApi = new MockApi(1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateMockJson() {
        final String result = MockApi.generateMockJson("id", "name", "").replaceAll("\\s+","");
        final String expected = """
                {
                  "id": "id",
                  "name": "name",
                  "column_values": [
                  ]
                }
                """.replaceAll("\\s+","");

        assertEquals(expected, result);
    }

    @Test
    void generateDriverJsonWithColumnValues() {
        final String[] columnValues = {
                MockApi.generateColumnValue("title", "text"),
                MockApi.generateColumnValue("title1", "text1"),
        };
        final String result = MockApi.generateMockJson("id", "name", String.join(",", columnValues)).replaceAll("\\s+","");
        final String expected = """
                {
                  "id": "id",
                  "name": "name",
                  "column_values": [
                   {
                     "title": "title",
                     "text": "text"
                   },
                   {
                     "title": "title1",
                     "text": "text1"
                   }
                  ]
                }
                """.replaceAll("\\s+","");

        assertEquals(expected, result);
    }

    @Test
    void generateColumnValue() {
        final String result = MockApi.generateColumnValue("title", "text").replaceAll("\\s+","");
        final String expected = """
                {
                  "title": "title",
                  "text": "text"
                }
                """.replaceAll("\\s+","");

        assertEquals(expected, result);
    }


    @Test
    void fetchDrivers() {
        for(int i = 0; i < 10; i++){
            String json = new MockApi(1).fetchDrivers();
            assertNotNull(json);
            boolean isValidJson = isValid(json);
            assertTrue(isValidJson);
        }
    }

    @Test
    void fetchCars() {
        for(int i = 0; i < 10; i++){
            String json = new MockApi(1).fetchCars();
            assertNotNull(json);
            boolean isValidJson = isValid(json);
            assertTrue(isValidJson);
        }
    }



    public boolean isValid(String json) {
        try {
            mapper.readTree(json);
        } catch (JacksonException e) {
            return false;
        }
        return true;
    }
}