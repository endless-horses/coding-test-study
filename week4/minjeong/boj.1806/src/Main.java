import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        int[] list = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (start <= N && end <= N) {
            if (sum >= S && min > end - start) min = end - start;
            if (sum < S) {
                sum += list[end];
                end++;
            } else {
                sum -= list[start];
                start++;
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}