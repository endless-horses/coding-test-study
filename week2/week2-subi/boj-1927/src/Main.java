import java.io.*;
import java.util.PriorityQueue;

public class Main {

	static PriorityQueue<Integer> PQ = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			switch (input) {
				case 0:
					if (PQ.isEmpty()) {
						bw.write(0 + "\n");
						break;
					}
					bw.write(PQ.poll() + "\n");
					break;
				default:
					PQ.add(input);
					break;
			}

			bw.flush();
		}

		bw.close();

	}

}