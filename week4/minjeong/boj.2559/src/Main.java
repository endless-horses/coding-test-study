import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(slidingWindow(list, K));
    }

    static int slidingWindow(int[] list, int K) {
        int max;
        int sum = 0;

        // 초기값 설정
        for (int i = 0; i < K; i++) {
            sum += list[i]; // 01234
        }

        max = sum;

        // 슬라이딩하면서 윈도우 이동: 한 칸씩 더하고, 이전 윈도우의 젤 앞 인덱스 빼고 max와 비교
        for (int i = 1; i+K <= list.length; i++) {
            sum += list[i+K-1];
            sum -= list[i-1];

            if (max < sum) max = sum;
        }

        return max;
    }
}