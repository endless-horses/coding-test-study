package week5.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
    static int N, K;
    static int[] count = new int[100_001];
    static int[] num;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = Integer.MIN_VALUE;
        while (end < N) {
            if (count[num[end]] < K) {
                count[num[end++]]++;
            } else {
                count[num[start++]]--;
            }
            answer = Math.max(answer, end - start);
        }

        System.out.println(answer);
    }
}