import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int start;
        int end;
        int sum;
        int count = 0;

        for (int i = 0; i < N; i++) {
            start = 0;
            end = N-1;

            while (true) {
                if (start == i) start++;
                else if (end == i) end--;

                if (start >= end) break;

                sum = list[start] + list[end];

                if (sum > list[i]) end--;
                else if (sum < list[i]) start++;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}   