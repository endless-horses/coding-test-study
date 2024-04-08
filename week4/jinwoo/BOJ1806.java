package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    static int N;
    static int S;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());        
    }

    private static int twoPointer() {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (start <= N && end <= N) {
            if (sum >= S && min > end - start) {
                min = end - start;
            }

            if (sum < S) {
                sum += num[end++];
            } else {
                sum -= num[start++];
            }

            if (start > end) start++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
