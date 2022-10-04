package API;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockApiTest {
    MockApi mockApi = new MockApi();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateDriverJson() {
        final String result = mockApi.generateDriverJson("id", "name", "").replaceAll("\\s+","");
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

    void generateDriverJsonWithColumnValues() {
        final String result = mockApi.generateDriverJson("id", "name", "").replaceAll("\\s+","");
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
    void generateColumnValue() {
        final String result = mockApi.generateColumnValue("title", "text").replaceAll("\\s+","");
        final String expected = """
                {
                  "title": "title",
                  "text": "text"
                }
                """.replaceAll("\\s+","");

        assertEquals(expected, result);
    }

    @Test
    void generateCarJson() {
        final String result = mockApi.generateCarJson("id", "name", "").replaceAll("\\s+","");
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
    void generateCarJsonWithColumnValues() {
        final String result = mockApi.generateCarJson("id", "name", "").replaceAll("\\s+","");
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
}