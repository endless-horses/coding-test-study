import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static Queue<String> in = new LinkedList<>();
	static Queue<String> out = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			in.add(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			out.add(br.readLine());
		}

		int result = 0;

		while (!in.isEmpty()) {
			String s = out.poll();
			if (!in.peek().equals(s)) {
				result++;
				in.remove(s);
			} else {
				in.poll();
				//out.poll();
			}
		}

		System.out.println(result);
	}
}