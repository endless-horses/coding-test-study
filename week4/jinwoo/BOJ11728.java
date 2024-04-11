package week4.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {
    static int N, M;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int ptr1 = 0;
        int ptr2 = 0;
        for (int i = 0; i < N + M; i++) {
            if (ptr1 == N) {
                sb.append(arr2[ptr2++]).append(" ");
            } else if (ptr2 == M) {
                sb.append(arr1[ptr1++]).append(" ");
            } else {
                if (arr1[ptr1] > arr2[ptr2]) {
                    sb.append(arr2[ptr2++]).append(" ");
                } else {
                    sb.append(arr1[ptr1++]).append(" ");
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}