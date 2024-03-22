package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class BOJ5397 {
    static final char LEFT = '<', RIGHT = '>', BACK_SPACE = '-';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String cmd = br.readLine();
            Stack<Character> left = new Stack();
            Stack<Character> right = new Stack();

            for (char c : cmd.toCharArray()) {
                if (c == LEFT) {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (c == RIGHT) {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (c == BACK_SPACE) {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : left) {
                sb.append(c);
            }
            Collections.reverse(right);
            for (char c : right) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
