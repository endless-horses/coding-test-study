import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> order = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            order.add(Integer.parseInt(br.readLine()));
        }

        int i = 1;
        while (!order.isEmpty()) {
            if (i <= order.getFirst()) {
                stack.push(i++);
                sb.append("+").append("\n");
            }
            if (!stack.empty() && Objects.equals(stack.peek(), order.getFirst())) {
                stack.pop();
                order.removeFirst();
                sb.append("-").append("\n");
            }
            else if (!stack.empty() && order.getFirst() < stack.peek()) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}