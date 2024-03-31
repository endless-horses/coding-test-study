import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> PQ = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			Long input = Long.parseLong(br.readLine());
			PQ.add(input);
		}

		long sum = 0;
		while (PQ.size() > 1) {
			long first = PQ.poll();
			long second = PQ.poll();

			sum += first + second;
			PQ.add(first + second);
		}

		System.out.println(sum);

	}
}