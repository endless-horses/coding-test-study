import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parents = new int[N+1];
        int vertex1;
        int vertex2;

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());

            nodes.get(vertex1).add(vertex2);
            nodes.get(vertex2).add(vertex1);
        }

        dfsRecursion(1);

        // queue.offer(1);
        // bfs();

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfsRecursion(int node) {
        visited[node] = true;
        for (int v : nodes.get(node)) {
            if (!visited[v]) {
                dfsRecursion(v);
                parents[v] = node;
            }
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int v : nodes.get(now)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                    parents[v] = now;
                }
            }
        }
    }
}