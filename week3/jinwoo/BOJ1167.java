package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {
    static int V;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int nodeIdx = 1;

    static int maxValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());

            while (true) {
                int V = Integer.parseInt(st.nextToken());
                if (V == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                graph.get(U).add(new Node(V, distance));
            }
        }

        visited = new boolean[V + 1];
        DFS(nodeIdx, 0);

        visited = new boolean[V + 1];
        DFS(nodeIdx, 0);


        System.out.println(maxValue);
    }

    private static void DFS(int cur, int sum) {
        visited[cur] = true;

        if (sum > maxValue) {
            maxValue = sum;
            nodeIdx = cur;
        }

        for (Node node : graph.get(cur)) {
            if (!visited[node.idx]) {
                DFS(node.idx, sum + node.distance);
            }
        }
    }
}

class Node {
    int idx;
    int distance;

    Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}