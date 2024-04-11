package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    static int N;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int target = num[i];
            int start = 0, end = N - 1;

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }

                if (end == i) {
                    end--;
                    continue;
                }

                int total = num[start] + num[end];

                if (total > target) {
                    end--;
                } else if (total < target) {
                    start++;
                } else {
                    cnt++;
                    break;
                    
                }
            }
        }

        System.out.println(cnt);
    }
}
