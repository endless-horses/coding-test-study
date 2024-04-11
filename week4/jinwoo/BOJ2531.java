package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2531 {
    // N: 초밥의 개수
    // D: 초밥의 가짓 수
    // K: 연속해서 먹는 접시 수
    // C: 쿠폰 번호
    static int N, D, K, C;
    static int[] sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = K - 1;
        int max = Integer.MIN_VALUE;

        while (start < N) {
            max = Math.max(max, getCount(start++, end++));
            if (end == N) end = 0;
        }

        System.out.println(max);
    }

    private static int getCount(int start, int end) {
        Set<Integer> set = new HashSet<>();

        int idx = start;
        while (idx != end) {
            set.add(sushi[idx++]);
            if (idx == N) idx = 0;
        }
        set.add(sushi[end]);
        set.add(C);

        return set.size();
    }
}
