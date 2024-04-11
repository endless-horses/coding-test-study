import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int start = 0;
        int end = N-1;
        int sum;
        int count = 0;

        while (start < end) {
            sum = list[start] + list[end];
            if (sum < M) start++;
            else if (sum > M) end--;
            else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}