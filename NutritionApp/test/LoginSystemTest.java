/*
 * This file contains JUnit test cases for LoginSystem.java
 */

import org.junit.*;

import static org.junit.Assert.*;

public class LoginSystemTest {
    LoginSystem system;

    @Before
    public void setUp() {
        system = new LoginSystem();
        try {
            system.registerUser("test", "0x0");
        } catch (exceptions.LoginException ignored) {}
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
        // TODO: write this test
        // Create a new user using system.registerUser(username, password)
        // Verify that the return value of system.getUser(username) is a User with username username.
        try {
            User result = system.getUser("test");
            String actual = result.getUsername();
            String expected = "test";
            assertEquals(expected, actual);
        } catch (exceptions.UsernameNotFoundException e) {
            fail();
        }
    }

}
