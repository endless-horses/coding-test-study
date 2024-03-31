package week2.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1240 {
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree[nodeA].add(new Node(nodeB, distance));
            tree[nodeB].add(new Node(nodeA, distance));
        }

        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            System.out.println(DFS(nodeA, nodeB, 0, visited));
        }
    }

    static int DFS(int start, int target, int distnace, boolean[] visited) {
        if (start == target) return distnace;

        visited[start] = true;
        int minDistance = Integer.MAX_VALUE;
        
        for (Node node : tree[start]) {
            if (!visited[node.next]) {
                int currentDistance = DFS(node.next, target, distnace + node.distance, visited);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }
        }

        visited[start] = false;
        return minDistance;
    }
}

class Node {
    int next;
    int distance;

    Node(int next, int distance) {
        this.next = next;
        this.distance = distance;
    }
}
