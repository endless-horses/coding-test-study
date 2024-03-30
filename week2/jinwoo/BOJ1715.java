package week2.jinwoo;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1715 {
    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            minHeap.add(sc.nextInt());
        }
        sc.close();

        int sum = 0;
        while (minHeap.size() >= 2) {
            int a = minHeap.remove();
            int b = minHeap.remove();

            minHeap.add(a + b);
            sum += a + b;
        }
        System.out.println(sum);
    }
}
