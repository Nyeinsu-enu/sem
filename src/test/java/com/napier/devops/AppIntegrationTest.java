package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppIntegrationTest {

    static App app;

    @BeforeAll
    void init() {
        app = new App();

        // Detect host from environment or default to localhost:33060
        String dbHost = System.getenv().getOrDefault("DB_HOST", "localhost:33060");

        System.out.println("Connecting to database at: " + dbHost);
        app.connect(dbHost, 30000);
    }

    @Test
    void testGetEmployee() {
        Employee emp = app.getEmployee(255530);
        assertNotNull(emp, "Employee should not be null");
        assertEquals(255530, emp.emp_no);
        assertEquals("Ronghao", emp.first_name);
        assertEquals("Garigliano", emp.last_name);
    }
}
