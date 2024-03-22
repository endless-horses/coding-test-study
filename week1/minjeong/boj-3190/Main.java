import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        HashMap<Integer, String> direction = new HashMap<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row-1][col-1] = 2; // 사과 있으면 -> 2
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) { // String으로 초, 방향 저장
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            direction.put(s, d);
        }

        int curX = 0;
        int curY = 0;

        // 동남서북
        int[] dx = {0, 1, 0, -1}; // 상, 하로 행 이동
        int[] dy = {1, 0, -1, 0}; // 우, 좌로 열 이동

        int currentDir = 0;

        int second = 0;
        int turn = 0;

        LinkedList<int []> snake = new LinkedList<>();
        snake.add(new int[]{0, 0}); // 이거의 의미는?
        board[0][0] = 1;

        while (true) {
            second++;

            curX += dx[currentDir];
            curY += dy[currentDir];

            if (curX < 0 || curY < 0 || curX >= N || curY >= N || board[curX][curY] == 1) {
                break;
            }

            if (board[curX][curY] == 2) { // 사과 먹음
                snake.add(new int[] {curX, curY});
            }
            else {
                int[] tail = snake.getFirst(); // getLast가 아닌 getFirst - why? 링리는 순서가 있음, 말은 꼬리지만 알고보면 꼬리가 젤 먼저 들어온 값임
                board[tail[0]][tail[1]] = 0;
                snake.add(new int[] {curX, curY});
                snake.remove(0);
            }

            board[curX][curY] = 1; // 뱀이 있는 자리 1로 mark

            if (turn < L) {
                if (direction.containsKey(second)) {
                    if (direction.get(second).equals("L")) {
                        currentDir = (currentDir - 1) % 4;
                        if (currentDir == -1) currentDir = 3;
                    }
                    else {
                        currentDir = (currentDir + 1) % 4;
                    }
                    turn++;
                }
            }
        }

        System.out.println(second);
    }
}