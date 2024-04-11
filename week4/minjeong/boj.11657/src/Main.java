import java.io.*;
import java.util.*;

class Node {
    int from;
    int to;
    int value;

    public Node(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}

public class Main {
    static ArrayList<Node> graph = new ArrayList<>();
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A, B, C;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
        }

        distance = new long[N+1];

        if (!bellmanFord(N)) {
            System.out.print(-1);
        } else {
            for (int i = 2; i < N+1; i++) {
                if (distance[i] == Integer.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(distance[i]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static boolean bellmanFord(int N) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        int start;
        int end;
        int value;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < graph.size(); j++) {
                start = graph.get(j).from;
                end = graph.get(j).to;
                value = graph.get(j).value;

                if (distance[start] != Integer.MAX_VALUE && distance[start] + value < distance[end]) {
                    distance[end] = distance[start] + value;
                    if (i == N-1) return false;
                }
            }
        }
        return true;
    }
}