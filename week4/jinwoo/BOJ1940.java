package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    static int N, M;
    static int[] materials;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        materials = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);
        
        int start = 0, end = N - 1, cnt = 0;
        while (start < end) {
            int total = materials[start] + materials[end];

            if (total > M) {
                end--;
            } else if (total < M) {
                start++;
            } else {
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);
    }
}
