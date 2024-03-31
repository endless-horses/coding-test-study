import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			PriorityQueue<Long> queue = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				long input = Integer.parseInt(st.nextToken());
				queue.add(input);
			}

			long result = 0;
			while (queue.size() > 1) { //2개가 남으니까
				long first = queue.poll();
				long second = queue.poll();

				long sum = first + second;
				result += sum;

				queue.add(sum);
			}


			bw.write(result + "\n");

		}
		bw.flush();
		bw.close();
	}
}

