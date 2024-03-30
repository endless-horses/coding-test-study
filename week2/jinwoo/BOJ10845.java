package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    private final static String PUSH = "push";
    private final static String POP = "pop";
    private final static String SIZE = "size";
    private final static String EMPTY = "empty";
    private final static String FRONT = "front";
    private final static String BACK = "back";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split(" ");
            String cmd = word[0];

            switch (cmd) {
                case PUSH:
                    deque.push(Integer.parseInt(word[1]));
                    break;
                case POP:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.removeLast());
                    }
                    break;
                case SIZE:
                    System.out.println(deque.size());
                    break;
                case EMPTY:
                    System.out.println(deque.isEmpty() ? "1" : "0");
                    break;
                case FRONT:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
                case BACK:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
            }
        }
    }
}
