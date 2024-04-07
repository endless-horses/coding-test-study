import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int sum = 0;

        Queue<Integer> que = new PriorityQueue<>(); // 자동으로 오름차순 정렬

        for (int i = 0; i < N; i++) {
            que.offer(Integer.parseInt(br.readLine()));
        }

        while (!que.isEmpty()) {
            sum = que.poll();
            if (que.isEmpty()) {
                break;
            } else {
                sum += que.poll();
                result += sum;
                que.offer(sum);
            }
        }

        System.out.println(result);
    }
}