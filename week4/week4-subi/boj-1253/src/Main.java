import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static long[] A;
	static Set<Long> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		A = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 1;
		int cnt = 0;

		while (true) {

			if (start == N - 1) {
				break;
			}

			set.add(A[start] + A[end]);
			end++;

			if (end == N) {
				start++;
				end = start + 1;
			}
		}

		for (long n : A) {
			if (set.contains(n)) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}
}