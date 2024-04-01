import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int sum = 0;

        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) deq.pollLast();
            else deq.addLast(num);
        }

        while (!deq.isEmpty()) {
            sum += deq.pollFirst();
        }

        System.out.println(sum);
    }
}