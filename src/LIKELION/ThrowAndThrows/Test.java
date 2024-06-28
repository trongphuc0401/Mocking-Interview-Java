package LIKELION.ThrowAndThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Test -
 *
 * @param
 * @return
 * @throws
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }
    static void readFile() throws FileNotFoundException {
        BufferedReader br;
        try {
            br =  new BufferedReader(new FileReader("./test.txt"));
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new FileNotFoundException();
        }
    }
}
