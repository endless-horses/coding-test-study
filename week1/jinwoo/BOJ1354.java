package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1354 {
    static Map<Long, Long> map = new HashMap<>();
    static long n, p, q, x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        System.out.println(sequence(n));
    }

    private static Long sequence(long n) {
        if (n <= 0) return 1L;
        if (map.containsKey(n)) return map.get(n);

        long result = sequence(n / p - x) + sequence(n / q - y);
        map.put(n, result);
        return result;
    }
}
