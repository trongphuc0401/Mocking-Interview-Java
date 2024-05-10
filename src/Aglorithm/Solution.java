package Aglorithm;
import java.io.*;

public class Solution {
    int[] JobScheduling(Job arr[], int n)
    {
        int[] schedulTime = {};

        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i].profit < arr[j].profit) {

                    swap(arr, i, j);
                }
            }
        }

        return schedulTime;
    }
    private static void swap(Job[] arr, int i, int j) {
        Job temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
