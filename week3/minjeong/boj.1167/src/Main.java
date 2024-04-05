import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        public int next, distance;
        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static boolean[] visited;
    static int max = 0, maxIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int start;
        int end;
        int distance;

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());

            while (true) {
                end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                distance = Integer.parseInt(st.nextToken());
                tree.get(start).add(new Node(end, distance));
            }
        }

        visited = new boolean[N+1];
        dfs(1, 0); // 가장 먼 노드 탐색 (max 정하기)

        visited = new boolean[N+1];
        dfs(maxIndex, 0);

        System.out.println(max); // 가장 먼 노드에서부터 탐색 (연결 돼있는 트리 올라오면서 더함)
    }

    static void dfs(int node, int dist) {
        if (dist > max) {
            max = dist;
            maxIndex = node;
        }
        visited[node] = true;
        for (Node n : tree.get(node)) {
            if (!visited[n.next]) dfs(n.next, dist + n.distance);
        }
    }
}