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
        final String result = mockApi.generateDriverJson("id", "name", "");
        final String expected = """
                {
                  "id": "id",
                  "name": "name",
                  "column_values": [
                  ]
                }
                """;

        assertTrue(expected.trim().contains(result.trim()));
    }

    @Test
    void generateColumnValue() {
        final String result = mockApi.generateColumnValue("title", "text");
        final String expected = """
                {
                  "title": "title",
                  "text": "text"
                }
                """;

        assertTrue(expected.trim().contains(result.trim()));
    }

    @Test
    void generateCarJson() {
        final String result = mockApi.generateCarJson("id", "name", "");
        final String expected = """
                {
                  "id": "id",
                  "name": "name",
                  "column_values": [
                  ]
                }
                """;

        assertTrue(expected.trim().contains(result.trim()));
    }
}