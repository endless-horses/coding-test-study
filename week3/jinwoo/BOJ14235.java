package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14235 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                System.out.println(priorityQueue.isEmpty() ? -1 : priorityQueue.poll());
            } else {
                for (int j = 0; j < cmd; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    priorityQueue.add(num);
                }
            }
        }
    }
}
