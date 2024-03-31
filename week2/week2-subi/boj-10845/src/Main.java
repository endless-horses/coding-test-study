import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		int last = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					int n = Integer.parseInt(st.nextToken());
					last = n;
					queue.add(n);
					break;
				case "pop":
					if (queue.isEmpty()) {
						bw.write(-1 + "\n");
						break;
					}
					bw.write(queue.poll() + "\n");
					break;
				case "size":
					bw.write(queue.size() + "\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						bw.write(1 + "\n");
					} else {
						bw.write(0 + "\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						bw.write(-1 + "\n");
						break;
					}
					bw.write(queue.peek() + "\n");
					break;
				case "back":
					if (queue.isEmpty()) {
						bw.write(-1 + "\n");
						break;
					}
					bw.write(last + "\n");
					break;
			}
			bw.flush();
		}

		bw.close();
	}
}