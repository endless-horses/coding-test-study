import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		//stack에 넣어야 하는 시작점을 cursor 변수로 저장해놓자!
		//cursor가 5라면 5부터 숫자를 넣을 수 있음
		int cursor = 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			while (cursor <= num) {
				stack.push(cursor++);
				sb.append("+\n");
			}

			if (stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}

		}
		System.out.println(sb);
	}
}