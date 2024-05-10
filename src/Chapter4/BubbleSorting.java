package Chapter4;

public class BubbleSorting {


    public static void bubbleSort(int[] numbers) {
        boolean numbersSwitched = false;
        do {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    int tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true;
                }
            }

        } while (numbersSwitched);
    }

    // Hàm in mảng
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // Testcase 1: Mảng đã sắp xếp tăng dần
        int[] arr1 = {1, 2, 3, 4, 5};
        bubbleSort(arr1);
        System.out.println("Testcase 1:");
        System.out.println("Expect: 1 2 3 4 5");
        System.out.print("Actual: ");
        printArray(arr1);
        System.out.println();

        // Testcase 2: Mảng đã sắp xếp giảm dần
        int[] arr2 = {5, 4, 3, 2, 1};
        bubbleSort(arr2);
        System.out.println("Testcase 2:");
        System.out.println("Expect: 1 2 3 4 5");
        System.out.print("Actual: ");
        printArray(arr2);
        System.out.println();

        // Testcase 3: Mảng ngẫu nhiên
        int[] arr3 = {3, 1, 4, 5, 2};
        bubbleSort(arr3);
        System.out.println("Testcase 3:");
        System.out.println("Expect: 1 2 3 4 5");
        System.out.print("Actual: ");
        printArray(arr3);
        System.out.println();
    }
}
