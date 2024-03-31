package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int n : list[start]) {
            if (!visited[n]) {
                parent[n] = start;
                dfs(n);
            }
        }
    }
}
