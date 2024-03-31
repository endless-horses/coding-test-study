package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                long num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }

            long sum = 0;
            while (queue.size() > 1) {
                long a = queue.poll();
                long b = queue.poll();

                queue.add(a + b);
                sum += a + b;
            }

            System.out.println(sum);
        }
    }
}
