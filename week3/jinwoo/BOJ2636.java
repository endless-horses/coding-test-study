package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2636 {
    static int N, M;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static final int AIR = 0, CHEESE = 1;
    static int cnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == CHEESE) cnt++;
            }
        }
        
        int time = 0;
        int cheese = 0;

        while (cnt > 0) {
            cheese = cnt;
            visited = new boolean[N][M];
            time++;
            BFS(0, 0);
        }

        System.out.println(time);
        System.out.println(cheese);
    }

    private static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == AIR) {
                        queue.add(new Node(nx, ny));
                    } else {
                        graph[nx][ny] = AIR;
                        cnt--;
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}