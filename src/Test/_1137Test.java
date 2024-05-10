package Test;

import LeetCode._1137;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class _1137Test {

    @Test
    public void testTribonacci() {
        _1137 test = new _1137();

        assertEquals(0, test.tribonacci(0));
        assertEquals(1, test.tribonacci(1));
        assertEquals(1, test.tribonacci(2));
        assertEquals(2, test.tribonacci(3));
    }

}