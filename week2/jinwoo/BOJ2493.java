package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Elem> stack = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            if (stack.isEmpty()) {
                stack.push(new Elem(i, height));
                sb.append("0 "); 
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(new Elem(i, height));
                        sb.append("0 ");
                        break;
                    }

                    Elem top = stack.peek();

                    if (top.height > height) {
                        sb.append(top.idx + " ");
                        stack.push(new Elem(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}

class Elem {
    int idx;
    int height;
    
    Elem(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}