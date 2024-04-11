package week4.jinwoo;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1644 {
    static int N;
    static boolean[] eratos = new boolean[4_000_001];
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        eratos();
        
        int start = 0, end = 0, total = 0, cnt = 0;
        
        while (true) {
            if (total >= N) {
                total -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                total += primes.get(end++);
            }
            if (total == N) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void eratos() {
        eratos[0] = eratos[1] = true;
        for (int i = 2; i * i <= eratos.length; i++) {
            if (!eratos[i]) {
                for (int j = i * i; j < eratos.length; j += i) {
                    eratos[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!eratos[i]) {
                primes.add(i);
            }
        }
    }
}
