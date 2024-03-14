import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();
		List<Integer> original = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			original.add(num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Collections.sort(list, (o1, o2) -> {
			if (map.get(o1) == map.get(o2)) {
				return original.indexOf(o1) - original.indexOf(o2);
			} else {
				return Integer.compare(map.get(o2), map.get(o1));
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(list.get(i) + " ");
		}

		System.out.println(sb);

	}
}