package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int N;
    static int[] num;
    static int X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(num);

        int start = 0;
        int end = 0;
        int cnt = 0;

        while (start < N) {
            if (start == end) {
                end++;
                if (end >= N) {
                    start++;
                    end = 0;
                }
            } else {
                // X와 동일
                if (num[start] + num[end] == X) {
                    cnt++;
                } 

                // X 이하
                if (num[start] + num[end] <= X) {
                    end++;
                    if (end >= N) {
                        start++;
                        end = 0;
                    }
                // X보다 큼
                } else {
                    start++;
                    end = 0;
                }
            }
        }

        System.out.println(cnt / 2);
    }
}
