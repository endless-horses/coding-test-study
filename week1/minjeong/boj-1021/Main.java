import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        int[] pick = new int[M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            pick[i] = Integer.parseInt(st.nextToken());
        }

        int a;

        for (int i = 0; i < pick.length; i++) {

            int index = queue.indexOf(pick[i]);

            if (index <= (queue.size()-1) - index) { // 앞이랑 더 가깝거나 중간인 경우는 여기다 해줘야 함
                while (true) { 
                    a = queue.getFirst();

                    if (a == pick[i]) {
                        queue.removeFirst(); // 1번 연산
                        break;
                    }
                    else { // 2번 연산
                        queue.add(a);
                        queue.removeFirst();
                        cnt++;
                    }
                }
            }

            else { // 뒤랑 더 가깝
                while (true) {
                    if (queue.getFirst() == pick[i]) {
                        queue.removeFirst();
                        break;
                    }
                    else {  // 3번 연산
                        a = queue.getLast();
                        queue.add(0, a);
                        queue.removeLast();
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}