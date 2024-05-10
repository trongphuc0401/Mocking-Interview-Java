package JavaCore;

public class PassByValue {
    int num = 8;

    public static void main(String[] args) {
       PassByValue  passByValue = new PassByValue();
       passByValue.change(passByValue);// passing value
        System.out.println(passByValue.num); // Output: 4
        System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
        System.out.printf("%-12.5s%s", "Hello World","World");
    }


    public static void change(PassByValue passByValue) {
        passByValue.num = passByValue.num + 4;// changes will be in the local variable only
    }
}
