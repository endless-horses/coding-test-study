package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ4803 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;         // 노드별 방문 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            graph = new ArrayList<>();
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());

                graph.get(U).add(V);
                graph.get(V).add(U);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (DFS(i, 0)) {
                        cnt++;
                    }
                }
            }

            switch (cnt) {
                case 0:
                    sb.append("Case ").append(idx).append(": No trees.").append("\n");
                    break;
                case 1:
                    sb.append("Case ").append(idx).append(": There is one tree.").append("\n");
                    break;
                default:
                    sb.append("Case ").append(idx).append(": A forest of ").append(cnt).append(" trees.").append("\n");
                    break;
            }
            
            idx++;
        }
        System.out.println(sb.toString());
    }

    private static boolean DFS(int current, int parent) {
        visited[current] = true;

        for (int node : graph.get(current)) {
            if (!visited[node]) {
                if (!DFS(node, current)) return false;
            } else if (node != parent) {
                return false;
            }
        }
        return true;
    }
}
