import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] DFS;
	static boolean[] dfsV;
	static ArrayList<Integer>[] BFS;
	static boolean[] bfsV;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		DFS = new ArrayList[N + 1];
		BFS = new ArrayList[N + 1];

		dfsV = new boolean[N + 1];
		bfsV = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			DFS[i] = new ArrayList<>();
			BFS[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			DFS[start].add(end);
			DFS[end].add(start);
			BFS[start].add(end);
			BFS[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(DFS[i]);
			Collections.sort(BFS[i]);
		}

		dfs(V);
		System.out.println();
		bfs(V);

	}

	static void dfs(int n) {

		dfsV[n] = true;
		System.out.print(n + " ");

		for (int now : DFS[n]) {
			if (!dfsV[now]) {
				dfs(now);
			}
		}

	}

	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		bfsV[n] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");

			for (int i : BFS[now]) {
				if (!bfsV[i]) {
					bfsV[i] = true;
					queue.add(i);
				}
			}
		}

	}

}