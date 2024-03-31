import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int x;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else {
                queue.offer(x);
            }
        }
        System.out.println(sb);
    }
}