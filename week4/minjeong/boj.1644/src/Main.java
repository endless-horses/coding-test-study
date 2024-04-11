import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getPrime(N);

        int start = 0, end = 0;
        int count = 0;
        int sum = 2;

        while (start < primes.size() && end < primes.size()) {
            if (sum < N) {
                end++;
                if (end >= primes.size()) break;
                sum += primes.get(end);
            } else {
                if (sum == N) count++;
                sum -= primes.get(start);
                start++;
            }
        }

        System.out.println(count);
    }

    static void getPrime(int N) {
        int temp[] = new int[N+1];
        for (int i = 2; i <= N; i++) {
            temp[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (temp[i] != 0) {
                for (int j = 2*i; j <= N; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (temp[i] != 0)
                primes.add(temp[i]);
        }
    }
}