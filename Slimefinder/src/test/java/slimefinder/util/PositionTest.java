package slimefinder.util;


import static org.junit.Assert.*;
import org.junit.*;

import slimefinder.util.Position;

public class PositionTest {

    @Test
    public void testParse() {
        String parsingFailures[] = {
            "h2,3",
            "--2,3",
            "-32,31,4",
            ",54,76",
            "5.2,4.0",
            "0:0,0:0:0",
            "-1000, 1000"};
        for (String parsingFailure : parsingFailures) {
            try {
                Position.parsePos(parsingFailure);
                fail("Expected a NumberFormatException to be thrown with the input " + parsingFailure);
            } catch (NumberFormatException e) {

            }
        }

        assertEquals(new Position(-1000, 1000), Position.parsePos("-1000,1000"));
        assertEquals(new Position(15, -50), Position.parsePos("\t  15,-50 \t "));
        assertEquals(new Position(3 * 16 + 3, -2 * 16 + 15), Position.parsePos("3:3,-2:15"));
    }
}