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
        // Use container hostname and port 3306
        app.connect("db:3306", 30000);
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
