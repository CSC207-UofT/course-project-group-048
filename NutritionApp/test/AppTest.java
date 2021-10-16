/*
 * This file contains JUnit test cases for ConsoleApp.java
 *
 * Complete the TODO in this file!
 */

import org.junit.*;

import javax.security.auth.login.LoginException;

import static org.junit.Assert.*;

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
        } catch (exceptions.LoginException e) {
            // We will not enter this block
            int i = 0;
        }

        try {
            app.login("test", "0x0");
        } catch (exceptions.LoginException e) {
            // We will not enter this block
            int i = 0;
        }

        assertNotNull(app.getUserUsername());
    }

}
