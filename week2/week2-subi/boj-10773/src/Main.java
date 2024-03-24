import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		long sum = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				stack.pop();
				continue;
			}

			stack.push(input);

		}

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		System.out.println(sum);

	}
}