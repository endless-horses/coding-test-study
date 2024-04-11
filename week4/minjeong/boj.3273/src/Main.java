import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int X = Integer.parseInt(br.readLine());
        int count = 0;

        int start = 0;
        int end = start + 1;
        int sum = list[start];

        while (start < N-1 || end < N) {
            sum += list[end];

            if (sum == X) count++;
            if (end == N-1 || sum == X || sum > X) {
                start++;
                sum = list[start];
                end = start + 1;
            }
            else {
                sum -= list[end];
                end++;
            }
        }

        System.out.println(count);
    }
}