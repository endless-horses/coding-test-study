import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointers(list));
    }

    static int twoPointers(int[] list) {
        int start = 0;
        int end = 0;
        int count = 0;
        int sum = list[start];

        while (start < N && end < N) {
            if (sum < M || start > end) {
                end++;
                if (end < N) sum += list[end];
            } else {
                if (sum == M) count++;
                sum -= list[start];
                start++;
            }
        }

        return count;
    }
}