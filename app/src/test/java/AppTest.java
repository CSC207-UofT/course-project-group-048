/*
 * This file contains JUnit test cases for ConsoleApp.java
 */

import org.junit.*;

import static org.junit.Assert.*;

import nutrition.exceptions.LoginException;

public class AppTest {
    App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test(timeout = 50)
    public void testLogin() {
        try {
            app.register("test", "0x0");
        } catch (LoginException e) {
            // We will not enter this block
        }

        try {
            app.login("test", "0x0");
        } catch (LoginException e) {
            // We will not enter this block
        }

        assertNotNull(app.getUserUsername());
    }
}
