package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 큐의 크기
        int m = Integer.parseInt(st.nextToken());   // 수의 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] seq = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int targetIdx = deque.indexOf(seq[i]);
            int halfIdx = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(answer);
    }
}
