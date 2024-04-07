import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<PriorityQueue<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        int start;
        int end;

        for (int i = 0; i <= N; i++) {
            nodes.add(new PriorityQueue<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        dfs(V);

        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        PriorityQueue<Integer> pq = new PriorityQueue<>(nodes.get(start)); // node 번호에 해당하는 PQ 가져와서 복사

        while (!pq.isEmpty()) {
            int node = pq.poll();
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        int cur;

        while (!que.isEmpty()) {
            cur = que.poll();
            sb.append(cur).append(" ");

            PriorityQueue<Integer> pq = new PriorityQueue<>(nodes.get(cur));

            while (!pq.isEmpty()) {
                int node = pq.poll();
                if (!visited[node]) {
                    que.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
}