import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		A = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int start = 0;
		int end = 0;
		int result = Integer.MAX_VALUE;
		int leng;
		while (end <= N) {
			if (sum >= S) {
				sum -= A[start++];
				leng = end - start + 1; // 길이를 구하기
				if (result > leng) result = leng; // 길이의 최솟값
			} else if (sum < S) {
				sum += A[end++];
			}
		}

		System.out.println((result) == Integer.MAX_VALUE ? 0 : result);


	}
}