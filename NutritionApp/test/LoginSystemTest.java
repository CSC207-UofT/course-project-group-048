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
    }

    @Test(timeout = 50)
    public void testUserExists() {
        // TODO: write this test.
        // Create a new user using system.registerUser(username, password)
        // Check that user exists with assertEquals(actual, expected)
    }

    @Test(timeout = 50)
    public void testUserDoesNotExist() {
        // TODO: write this test.
        // Create a new user using system.registerUser(username, password)
        // Check that a different username does not exist with assertEquals(actual, expected)
    }

    @Test(timeout = 50)
    public void testGetUser() {
        // TODO: write this test
        // Create a new user using system.registerUser(username, password)
        // Verify that the return value of system.getUser(username) is a User with username username.
    }

}
