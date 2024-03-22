
package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;   // 보드의 크기 (N x N)
    static int K;   // 사과의 개수
    static int L;   // 방향 변환 횟수
    static int[][] map;
    static Map<Integer, String> change = new HashMap<>();
    static List<int[]> snake = new ArrayList<>();
    static final int APPLE = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = APPLE;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int turn = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            change.put(turn, dir);
        }
        game();
    }

    private static void game() {
        int x = 0, y = 0;
        int time = 0;
        int d = 1;
        snake.add(new int[] {0, 0});

        while (true) {
            time++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 몸통 충돌 체크
            if (isFinish(nx, ny)) {
                break;
            }

            // 사과 먹음 => 몸통 길이 증가
            if (map[nx][ny] == APPLE) {
                map[nx][ny] = 0;
                snake.add(new int[] {nx, ny});
            } else {
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }

            if (change.containsKey(time)) {
                if (change.get(time).equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    private static boolean isFinish(int nx, int ny) {
        // 벽 충돌 체크
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if (nx == s[0] && ny == s[1]) return true;
        }
        return false;
    }
}