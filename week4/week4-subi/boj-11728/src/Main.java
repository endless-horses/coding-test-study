import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Long> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Long.parseLong(st.nextToken()));

		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}

		Collections.sort(arr);

		StringBuilder sb = new StringBuilder();

		for (long a : arr) {
			sb.append(a + " ");

		}
		System.out.println(sb);

	}
}