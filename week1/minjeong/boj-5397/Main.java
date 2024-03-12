import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String regex = br.readLine();
            Stack<Character> pwLeft = new Stack<>();
            Stack<Character> pwRight = new Stack<>();

            for (char c : regex.toCharArray()) {
                switch (c) {
                    case '<':
                        if (!pwLeft.isEmpty())
                            pwRight.push(pwLeft.pop());
                        break;
                    case '>':
                        if (!pwRight.isEmpty())
                            pwLeft.push(pwRight.pop());
                        break;
                    case '-':
                        if (!pwLeft.isEmpty())
                            pwLeft.pop();
                        break;
                    default:
                        pwLeft.push(c);
                        break;
                }
            }

            while (!pwRight.isEmpty()) {
                pwLeft.push(pwRight.pop());
            }

            for (char c : pwLeft) {
                sb.append(c);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}