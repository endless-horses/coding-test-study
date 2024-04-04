package week3.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1922 {
    static int N, M;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(nodeA, nodeB, distance));
        }

        Collections.sort(edgeList);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (Edge edge : edgeList) {
            if (find(edge.nodeA) != find(edge.nodeB)) {
                union(edge.nodeA, edge.nodeB);
                answer += edge.distance;
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}

class Edge implements Comparable {
    int nodeA;
    int nodeB;
    int distance;

    Edge(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    @Override
    public int compareTo(Object o) {
        return this.distance - ((Edge)o).distance;
    }
}