import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<Long, Long> map = new HashMap<>();
	static long n, p, q, x, y;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());

		System.out.println(solve(n));

	}

	public static long solve(long i) {
		if (i <= 0) {
			return 1;
		}
		if (map.containsKey(i)) {
			return map.get(i);
		}
		long result = solve(i / p - x) + solve(i / q - y);
		map.put(i, result);
		return result;
	}

}
