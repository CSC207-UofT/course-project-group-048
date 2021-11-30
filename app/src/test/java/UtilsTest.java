import org.junit.*;

import static org.junit.Assert.assertEquals;

import nutrition.Utils;

public class UtilsTest {

    @Test(timeout = 50)
    public void testGetHash() {
        String str = "Hello World!";
        String actual = Utils.getHash(str);
        String expected = "7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069";
        assertEquals(expected, actual);
    }

}
