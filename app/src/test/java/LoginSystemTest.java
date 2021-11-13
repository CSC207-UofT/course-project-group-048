/*
 * This file contains JUnit test cases for LoginSystem.java
 */

import org.junit.*;

import static org.junit.Assert.*;

import nutrition.LoginSystem;
import nutrition.User;
import nutrition.exceptions.LoginException;
import nutrition.exceptions.UsernameNotFoundException;

public class LoginSystemTest {
    LoginSystem system;

    @Before
    public void setUp() {
        system = new LoginSystem();
        try {
            system.registerUser("test", "0x0");
        } catch (LoginException ignored) {}
    }

    @Test(timeout = 50)
    public void testUserExists() {
        boolean result = system.userExists("test");
        assertTrue(result);
    }

    @Test(timeout = 50)
    public void testUserDoesNotExist() {
        boolean result = system.userExists("test2");
        assertFalse(result);
    }

    @Test(timeout = 50)
    public void testGetUser() {
        try {
            User result = system.getUser("test");
            String actual = result.getUsername();
            String expected = "test";
            assertEquals(expected, actual);
        } catch (UsernameNotFoundException e) {
            fail();
        }
    }

}
