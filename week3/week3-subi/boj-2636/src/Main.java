import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int cnt = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cnt++;
			}
		}

		int time = 0;
		int cheese = 0;

		while (cnt > 0) {
			cheese = cnt;
			time++;
			visited = new boolean[N][M]; //방문배열 초기화
			bfs(0, 0);
		}

		System.out.println(time);
		System.out.println(cheese);

	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nowX = dx[k] + now[0];
				int nowY = dy[k] + now[1];

				if (nowX >= 0 && nowX < N && nowY >= 0 && nowY < M) {
					if (!visited[nowX][nowY]) {
						visited[nowX][nowY] = true;
						if (map[nowX][nowY] == 0) { //치즈가 아니면
							queue.add(new int[] {nowX, nowY}); // 치즈가 나올떄까지 탐색
						} else { //치즈를 만나면
							map[nowX][nowY] = 0; //없애주고
							cnt--; //치즈갯수 줄이기
						}
					}
				}


			}
		}

	}

}