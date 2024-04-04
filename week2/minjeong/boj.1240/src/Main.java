import java.io.*;
import java.util.*;

class Node {
    int next, distance;
    public Node(int next, int distance) {
        this.next = next;
        this.distance = distance;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start;
        int end;
        int distance;

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Node(end, distance));
            tree.get(end).add(new Node(start, distance));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            sb.append(bfs(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int start, int end) {
        Queue<Node> que = new LinkedList<>();
        visited[start] = true;
        que.add(new Node(start, 0));
        Node cur;

        while (!que.isEmpty()) {
            cur = que.poll();

            if (cur.next == end) return cur.distance;
            for (Node node : tree.get(cur.next)) {
                if (!visited[node.next]) {
                    visited[node.next] = true;
                    que.add(new Node(node.next, cur.distance + node.distance));
                }
            }
        }

        return -1;
    }
}