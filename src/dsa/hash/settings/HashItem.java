package dsa.hash.settings;

import java.util.HashMap;

public class HashItem {

    static final int SIZE = 20;

    static class DataItem {
        int data;
        int key;
        DataItem(int data, int key) {
            this.data = data;
            this.key = key;
        }
    }

    static DataItem[] hashArray = new DataItem[SIZE];
    static DataItem dummyItem = new DataItem(-1, -1);
    static DataItem item;
    static int hashCode(int key) {
        return key % SIZE;
    }

    static DataItem search(int key) {
        int hashIndex = hashCode(key);

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key)
                return hashArray[hashIndex];

            hashIndex = (hashIndex + 1) % SIZE;
        }
        return null;
    }

    static void insert(int key, int data) {
        DataItem item = new DataItem(data, key);
        int hashIndex = hashCode(key);

        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            hashIndex = (hashIndex + 1) % SIZE;
        }
        hashArray[hashIndex] = item;
    }

    static DataItem deleteItem(DataItem item) {
        int key = item.key;
        int hashIndex = hashCode(key);
        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = dummyItem;
                return temp;
            }
            hashIndex = (hashIndex + 1) % SIZE;
        }
        return null;
    }

    static void display() {
        for (int i = 0; i < SIZE ; i++) {
            if (hashArray[i] != null) {
                System.out.print(" (" + hashArray[i].key + "," + hashArray[i].data + ")");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(1, 20);
        insert(2, 70);
        insert(42, 80);
        insert(4, 25);
        insert(12, 44);
        insert(14, 32);
        insert(17, 11);
        insert(13, 78);
        insert(37, 97);
        System.out.print("Insertion done");
        System.out.print("\nContents of Hash Table:");
        display();

        int ele = 37;
        System.out.print("The element to be searched: " + ele);
        item = search(37);

        if (item != null) {
            System.out.println("\nElement found: " + item.key);
        } else {
            System.out.println("\nElement not found");
        }
        deleteItem(item);

        System.out.print("Hash Table contents after deletion:");
        display();
    }


}
