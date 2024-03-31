import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		Stack<Integer> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {

			while (!stack.isEmpty()) {
				if (stack.peek() < num[i]) { //3이랑 5랑 비교해서 3이 더 작으면 //5랑 2랑 비교해서 5가 더 크면
					stack.add(num[i]); //5대입
					num[i - 1] = stack.peek(); //3을 5로
					break;
				}
			}
			stack.add(num[i]);//3
		}

		for (int i = 0; i < N; i++) {
			System.out.print(num[i] + " ");
		}

	}
}