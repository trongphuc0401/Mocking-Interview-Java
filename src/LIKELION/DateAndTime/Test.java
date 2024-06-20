package LIKELION.DateAndTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Test -
 *
 * @param
 * @return
 * @throws
 */
public class Test {
    public static void main(String[] args) {
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(formatter);
    }
}
