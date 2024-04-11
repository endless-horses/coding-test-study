package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    static int N, M;
    static int[] num;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointers());
    }

    private static int twoPointers() {
        int start = 0, end = 0, total = 0, cnt = 0;

        while (true) {
            if (total >= M) {
                total -= num[start++];
            } else if (end == N) {
                break;
            } else {
                total += num[end++];
            }
            
            if (total == M) {
                cnt++;
            }
        }

        return cnt;
    }
}
