package dsa.array;

public class Settings {

    /**
     * Insert element into array
     * @param arr
     * @param n
     * @param key
     * @param capicity
     * @return
     */
    public static int insert(int arr[], int n, int key, int capicity) {
        if (n >= capicity) {
            return n;
        }
        arr[n] = key;
        return n + 1;
    }

    /**
     * Đây là hàm insert Element của em
     * @param arr
     * @param n
     * @param x
     * @param pos
     */
    public static void insertElement(int arr[], int n, int x, int pos) {
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = x;

    }

    public static int insertSorted(int arr[], int n, int key, int capicity) {
        if (n >= capicity) {
            return n;
        }
        int i;

        for (i = n - 1; (i >= 0 && arr[i] > key); i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = key;
        return (n + 1);
    }

    public static int findElementByLinearSearch(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
    public static long findElementByLinearSearchWithLong(long arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1L;
    }
    public static void findElementByLinearSearchWithVoid(int arr[] , int n , int key) {
        for(int i = 0; i< n; i++) {
            if(arr[i] == key) {
                System.out.println("Element is found: " + i);
            }
        }
        System.out.println("Element not Found ");
    }

    public static int findElementByBinarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key > arr[mid])
            return findElementByBinarySearch(arr, (mid + 1), high, key);
        return findElementByBinarySearch(arr, (mid - 1), high, key);
    }


    private static int fibonacciSearch(int[] arr, int key, int n) {
        int fibMMm2 = 0;
        int fibMMm1 = 1;
        int fibM = fibMMm2 + fibMMm1;

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offSet = -1;

        while (fibM > 1) {
            int i = minimum(offSet + fibMMm2, n - 1);

            if (arr[i] < key) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offSet = i;
            } else if (arr[i] > key) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return i;
            }
            if (fibMMm1 == 1 && arr[n - 1] == key)
                return n - 1;




        }
        return -1;
    }

    public static int minimum(int key, int y) {
        return (key <= y) ? key:y;
    }

    public static int deleteElement(int arr[] ,int n, int key) {
        int pos  = findElementByLinearSearch(arr,n, key);

        if(pos == -1) {
            System.out.println("Element not Found");
            return n;
        }

        for(int i = pos ; i < n-1 ; i++) {
            arr[i] = arr[i +1];
        }
        return n-1;
    }

    public static int deleteElementByBinarySearch(int arr[], int n,int key) {
        int pos = findElementByBinarySearch(arr, 0, n-1, key);

        if (pos == -1) {
            System.out.println("Element not found");
        }
        for(int i = pos ; i < n-1 ;i++) {
            arr[i] =arr[i+1];
        }
        return n-1;
    }

    public static void main(String[] args) {

        int[] arr = new int[20];
        arr[0]  = 12;
        arr[1] = 44;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = 20;
        int n = 6;
        int i, key = 26;
        int pos=2;
        int size = arr.length-1;
        System.out.println("Before Insertion: ");
        for(i = 0;i<n;i++) {
            System.out.println(arr[i]+" ");
        }
        n = insertSorted(arr,n,key,capacity);
        int position = findElementByLinearSearch(arr,n,key);

        System.out.println("After Insertion: ");
        for(i = 0;i<n;i++) {
            System.out.println(arr[i]+" ");
        }
        insertElement(arr,n,key,pos);

        System.out.println("After Insertion: ");
        for(i = 0;i<n;i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println("Element: " + position);
        System.out.println("Element by Binary search: "+findElementByBinarySearch(arr,0,size,key));
        System.out.println("Element by Fibonacci Search" + fibonacciSearch(arr,key,n));
    }


}
