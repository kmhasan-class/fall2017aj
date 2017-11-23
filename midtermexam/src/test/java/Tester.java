import bd.ac.seu.aj.midtermexam.NumberOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tester {

    @Test
    public void testConversion() {
        String string = "120";
        byte number = Byte.parseByte(string);
        byte expectedValue = 120;
        assertEquals(expectedValue, number);
    }

    @Test
    public void testNumberOutOfRange() {
        String string = "200";
        assertThrows(NumberOutOfRangeException.class, () -> {
            byte number = Byte.parseByte(string);
            System.out.println(number);
        });
    }

    @Test
    public void testInvalidCharacter() {
        String string = "20+a";
        assertThrows(NumberFormatException.class, () -> {
            byte number = Byte.parseByte(string);
            System.out.println(number);
        });
    }
}
