package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static final int EMPTY = 0, WALL = 1, VIRUS = 2;
    static int answer = 0;
    static List<Vertex> virusList = new ArrayList<>();

    static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;

                if (value == VIRUS) virusList.add(new Vertex(i, j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == EMPTY) {
                    visited = new boolean[N][M];
                    graph[i][j] = WALL;
                    DFS(i, j, 1);
                    graph[i][j] = EMPTY;
                }
            }
        }

        System.out.println(answer);
    }

    static void DFS(int x, int y, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, BFS());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == VIRUS) continue;
                if (graph[i][j] == WALL) continue;

                graph[i][j] = WALL;
                DFS(i, j, depth + 1);
                graph[i][j] = EMPTY;
            }
        }
    }

    static int BFS() {
        visited = new boolean[N][M];
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex v : virusList) {
            queue.add(v);
            visited[v.x][v.y] = true;
        }
        
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (graph[nx][ny] == WALL) continue;
                if (graph[nx][ny] == VIRUS) continue;
                if (!visited[nx][ny]) {
                    queue.add(new Vertex(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return getEmptyCount();
    }

    static int getEmptyCount() {
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] != WALL) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Vertex {
    int x;
    int y;

    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}