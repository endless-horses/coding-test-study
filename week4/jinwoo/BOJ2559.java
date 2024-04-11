package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    static int N, K;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;

        while (end < N) {
            if (end - start == K) {
                total -= num[start++];
                total += num[end++];
            } else {
                total += num[end++];
            }

            if (max < total && end - start == K) {
                max = total;
            }
        }

        System.out.println(max);
    }
}
