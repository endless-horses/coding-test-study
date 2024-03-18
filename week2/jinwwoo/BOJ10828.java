package week2.jinwwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
    static final String PUSH = "push", 
                        POP = "pop", 
                        SIZE = "size", 
                        EMPTY = "empty", 
                        TOP = "top";


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case PUSH:
                    stack.push(cmd[1]);
                    break;
                case POP:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.pop());
                    break;
                case SIZE:
                    System.out.println(stack.size());
                    break;
                case EMPTY:
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case TOP:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.peek());
                    break;
            }
        }
        
    }
}
