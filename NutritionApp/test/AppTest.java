/*
 * This file contains JUnit test cases for ConsoleApp.java
 */

import org.junit.*;

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
        }

        try {
            app.login("test", "0x0");
        } catch (exceptions.LoginException e) {
            // We will not enter this block
        }

        assertNotNull(app.getUserUsername());
    }

    @Test(timeout = 50)
    public void testGetHash() {
        String str = "Hello World!";
        String actual = app.getHash(str);
        String expected = "7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069";
        assertEquals(expected, actual);
    }
}
