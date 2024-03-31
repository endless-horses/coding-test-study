package week2.jinwoo;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int x = 0; x < n; x++) {
            int num = sc.nextInt();

            if (num > 0) {
                minHeap.add(num);
            } else {
                if (minHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(minHeap.remove());
                }
            }
        }
    }
}
