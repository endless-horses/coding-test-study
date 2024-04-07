package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int N, M, V;     // N: 노드 수, M: 간선 수, V: 루트 노드 번호
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i)); 
        }

        visited = new boolean[N + 1];
        DFS(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        BFS(V);
        sb.append("\n");
        
        System.out.println(sb.toString());
    }

    private static void DFS(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int node : graph.get(cur)) {
            if (!visited[node]) {
                DFS(node);
            }
        }
    }

    private static void BFS(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;
        sb.append(cur).append(" ");

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int node : graph.get(cur)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    sb.append(node).append(" ");
                }
            }
        }
    }
}