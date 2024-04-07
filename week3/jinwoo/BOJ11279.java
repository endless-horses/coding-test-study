package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11279 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> num2 - num1);
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                System.out.println(maxHeap.isEmpty() ? 0 : maxHeap.poll());
            } else {
                maxHeap.add(num);
            }
        }
    }
}
