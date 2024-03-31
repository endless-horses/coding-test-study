package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15681 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] count;
    static int N, R, Q;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        DFS(R, -1);

        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            System.out.println(count[node]);
        }
    }

    static void DFS(int x, int parent) {
        count[x] = 1;
        for (int y : graph.get(x)) {
            if (y == parent) continue;
            DFS(y, x);
            count[x] += count[y];
        }
    }
}
