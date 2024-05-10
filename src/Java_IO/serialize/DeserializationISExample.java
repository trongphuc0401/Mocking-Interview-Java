package Java_IO.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationISExample {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = null;
        String filePath = "E:/Interview_Java/Interview/src/data/engineer.txt";
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            Engineer engineer = (Engineer) ois.readObject();
            System.out.println(engineer);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            ois.close();
        }

    }
}
