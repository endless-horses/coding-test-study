package week2.jinwoo;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> num2 - num1);

        for (int x = 0; x < n; x++) {
            int num = sc.nextInt();

            if (num > 0) {
                maxHeap.add(num);
            } else {
                if (maxHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(maxHeap.remove());
                }
            }
        }
    }
}
