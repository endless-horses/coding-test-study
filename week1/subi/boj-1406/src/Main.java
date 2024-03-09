import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();

		int M = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			left.push(s.charAt(i));
		}

		for (int i = 0; i < M; i++) {
			String ss = br.readLine();
			char c = ss.charAt(0);

			switch (c) {
				case 'L':
					if (!left.isEmpty()) right.push(left.pop());
					break;
				case 'D':
					if (!right.isEmpty()) left.push(right.pop());
					break;
				case 'B':
					if (!left.isEmpty()) left.pop();
					break;
				case 'P':
					left.push(ss.charAt(2));
					break;
			}
		}

		while (!left.isEmpty()) {
			right.add(left.pop());
		}

		while (!right.isEmpty()) {
			bw.write(right.pop());
		}

		bw.flush();
		bw.close();

	}
}