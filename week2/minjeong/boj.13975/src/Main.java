import java.io.*;
import java.util.*;

public class Main {

    static Queue<Long> files = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int K;
        Long sum;
        Long result;

        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            result = 0L;

            for (int j = 0; j < K; j++) {
                files.offer((long) Integer.parseInt(st.nextToken()));
            }

            while (files.size() > 1) {
                sum = files.poll() + files.poll();
                result += sum;
                files.offer(sum);
            }

            files.clear();

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}