package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (Character c : br.readLine().toCharArray()) {
            left.push(c);
        }
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            command(br.readLine());
        }
        System.out.println(getResult());
    }

    private static void command(String cmd) {
        if ('L' == cmd.charAt(0)) {
            if (!left.isEmpty()) right.push(left.pop());
        } else if ('D' == cmd.charAt(0)) {
            if (!right.isEmpty()) left.push(right.pop());
        } else if ('B' == cmd.charAt(0)) {
            if (!left.isEmpty()) left.pop();
        } else {
            left.push(cmd.charAt(2));
        }
    }

    private static String getResult() {
        StringBuilder sb = new StringBuilder();
        for (Character s : left) {
            sb.append(s);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        return sb.toString();
    }
}