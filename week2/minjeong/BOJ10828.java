import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        String command;
        Stack<Integer> stack = new Stack<>();

        int X;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) {
                X = Integer.parseInt(st.nextToken());
                stack.push(X);
            }
            else if (command.equals("pop")) {
                if (stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            }
            else if (command.equals("empty")) {
                if (stack.empty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (command.equals("top")) {
                if (stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}