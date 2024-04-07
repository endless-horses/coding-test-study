import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[] dp; // 각 노드의 자식의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        int start;
        int end;
        dp = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        visited[R] = true;
        dfs(R);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(dp[q]).append("\n");
        }

        System.out.println(sb);
    }

    public static int dfs(int node) {
        int count = 1;
        for (int v : nodes.get(node)) {
            if (!visited[v]) {
                visited[v] = true;
                count += dfs(v); // 방문하는 만큼 자식의 수 더해감(+1씩)
            }
        }
        return dp[node] += count;
    }
}