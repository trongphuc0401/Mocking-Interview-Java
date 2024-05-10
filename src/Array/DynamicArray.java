package Array;

public class DynamicArray {
    private int[] arr;

    private int count;

    public DynamicArray(int length) {
        arr = new int[length];

    }

    public void insert(int index) {
        if(arr.length == count) {
         int newArray[] = new int[2*count];

         for(int i = 0; i < count; i++) {
             newArray[i] = arr[i];
         }
         arr = newArray;
        }
        arr[count++] = index;
    }

    public void printArray()
    {

        // Iterating over array using for loop
        for (int i = 0; i < count; i++) {

            // Print the elements of an array
            System.out.print(arr[i] + " ");
        }
    }

    public class GFG {

        // Main driver method
        public static void main(String[] args)
        {

            // Creating object of Array(user-defined) class
            DynamicArray numbers = new DynamicArray(3);

            // Adding elements more than size specified above
            // to the array to illustrate dynamic nature
            // using the insert() method

            // Custom input elements
            numbers.insert(10);
            numbers.insert(30);
            numbers.insert(40);
            numbers.insert(50);

            // Calling the printArray() method to print
            // new array been dynamically created
            numbers.printArray();
        }
    }

}
