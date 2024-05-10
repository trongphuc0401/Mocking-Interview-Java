package dsa.hash;

import java.util.ArrayList;

public class MyHashSet {

    private final int SIZE = 1000;

    private ArrayList<Integer> list[];

    public MyHashSet() {
        list = new ArrayList[SIZE];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public int hashFunction(int key) {
        return key % SIZE;
    }
    public void add(int key) {

        int hashValueIndex = hashFunction(key);

        var bucket = list[hashValueIndex];

        int keyIndex = bucket.indexOf(key);

        if (keyIndex < 0) {
            bucket.add(key);
        }

    }

    public void remove(int key) {
        int hashValueIndex = hashFunction(key);

        var bucket = list[hashValueIndex];

        int keyIndex = bucket.indexOf(key);

        if (keyIndex >= 0) {
            bucket.remove(keyIndex);
        }
    }

    public boolean contains(int key) {
        int hashValueIndex = hashFunction(key);

        var bucket = list[hashValueIndex];

        int keyIndex = bucket.indexOf(key);
        return keyIndex >=0;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.remove(1);

    }
}
