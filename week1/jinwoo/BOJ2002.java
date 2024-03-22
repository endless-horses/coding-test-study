package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        int[] outSeq = new int[n];
        for (int i = 0; i < n; i++) {
            outSeq[i] = map.get(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (outSeq[i] > outSeq[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
