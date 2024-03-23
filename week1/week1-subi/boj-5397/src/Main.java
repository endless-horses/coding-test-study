import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for (int i = 0; i < N; i++) {

			String input = br.readLine();

			for (Character c : input.toCharArray()) {
				//default 빼고 나머지에 case에 break를 해줘야 문자만 left.push() 된다.
				switch (c) {
					case '<':
						if (!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case '>':
						if (!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case '-':
						if (!left.isEmpty()) {
							left.pop();
						}
						break;
					default:
						left.push(c);
				}
			}


			while (!left.isEmpty()) {
				right.push(left.pop());
			}

			while (!right.isEmpty()) {
				bw.write(right.pop());
			}

			bw.write("\n");

		}

		bw.flush();
		bw.close();
	}
}