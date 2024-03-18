package week2.jinwoo;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        for (int i = 0; i < n; i++) {
            int num = seq[i];

            while (num >= idx) {
                stack.push(idx++);
                sb.append("+\n");
            }
            if (stack.pop() != num) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        
        System.out.println(sb);
    }    
}