package Java_IO.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationISExample {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos  =null;
        String filePath = "E:/Interview_Java/Interview/src/data/engineer.txt";

        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            Engineer engineer = new Engineer(1,"Phuc 123", "Java");
            oos.writeObject(engineer);
            oos.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            oos.close();
        }
        System.out.println("success...");
    }
}
