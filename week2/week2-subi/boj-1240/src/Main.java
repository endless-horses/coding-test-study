import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int next;
	int d;

	Node(int next, int d) {
		this.next = next;
		this.d = d;
	}

}

public class Main {
	static int N = 0, M = 0;
	static ArrayList<Node> A[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			A[start].add(new Node(end, dis));
			A[end].add(new Node(start, dis));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(bfs(start, end));
		}
	}

	static int bfs(int start, int end) {

		Queue<Node> queue = new LinkedList<>();
		visited = new boolean[N + 1];

		queue.add(new Node(start, 0)); //사작점이랑 거리
		visited[start] = true;

		int result = 0;
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.next == end) {
				result = now.d;
				break;
			}

			for (Node n : A[now.next]) {
				if (!visited[n.next]) {
					visited[n.next] = true;
					queue.add(new Node(n.next, now.d + n.d));
				}
			}
		}

		return result;
	}
}