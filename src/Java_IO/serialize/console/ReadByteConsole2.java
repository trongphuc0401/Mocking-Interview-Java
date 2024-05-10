package Java_IO.serialize.console;

import java.io.IOException;

public class ReadByteConsole2 {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Nhập chuỗi kí tự");
            byte[] bytes = new byte[100];

            int length = System.in.read(bytes);

            String str = new String(bytes, 0 ,length -1);

            if (str.equalsIgnoreCase("EXIT")) {
                System.out.println("Finished!");
                break;
            }
            System.out.println("chuỗi nhận được: "+ str);
        }
    }
}
