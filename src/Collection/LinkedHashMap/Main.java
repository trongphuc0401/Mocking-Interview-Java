package Collection.LinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashSet;

/*
* class này tạo ra để thi hành ví dụ về Linked Hash Map
*
* LinkedHashMap là một phiên bản rộng của HashSet nhưng có điều HashSet không thể duy trì  các thứ tự được LinkedHashSet bên trong có LinkedHashMap
* lại có thể duy trì các thứ tự chèn của các phần tử.
*
* Trong bài này ta sẽ sử dụng LinkedHashSet sử dụng doubly linked list bên trong để lưu trữ các phần tử chèn Chúng ta có thể nhìn thấy làm thế nào
* LinkedHashSet hoạt động trong bài dưới đây.
*
*
*
* */
public class Main {
    public static void main(String[] args) {

        LinkedHashSet<Customer> set = new LinkedHashSet<>();

        set.add(new Customer("Jack", 021));

        set.add(new Customer("Peter", 105));

        set.add(new Customer("Ramesh", 415));

        set.add(new Customer("Julian", 814));

        set.add(new Customer("Avinash", 105));      //Duplicate Element

        set.add(new Customer("Sapna", 879));

        set.add(new Customer("John", 546));

        set.add(new Customer("Moni", 254));

        set.add(new Customer("Ravi", 105));

        Iterator<Customer> it = set.iterator();

        while (it.hasNext())
        {
            Customer customer = (Customer) it.next();

            System.out.println(customer);
        }

    }

}
