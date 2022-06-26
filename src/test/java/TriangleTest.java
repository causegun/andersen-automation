import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void verifyNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Triangle.area(-2, 1, 4));
        logger.info(exception.getMessage());
        assertEquals("side of a triangle can't be negative", exception.getMessage());
    }

    @Test
    void verifyOneSideLessThanSumOfOthers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Triangle.area(2, 1, 4));
        logger.info(exception.getMessage());
        assertEquals("each side of a triangle should be greater than sum of other sides", exception.getMessage());
    }

    @Test
    void verifyLegalInput() {
        double area = Triangle.area(7, 12, 10);
        logger.info(String.valueOf(area));
        assert (area == 34.98);
    }
}