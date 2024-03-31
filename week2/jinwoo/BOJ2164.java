package week2.jinwoo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (queue.size() > 1) {
            if (cnt % 2 == 0) {
                queue.remove();
            } else {
                queue.add(queue.remove());
            }
            cnt++;
        }

        System.out.println(queue.remove());
    }
}
