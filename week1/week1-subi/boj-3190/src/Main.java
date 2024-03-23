import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N = 0, K = 0, L = 0;
	static int[][] map;
	static Map<Integer, String> dir = new HashMap<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	//행/열로 보면
	//밑으로 내려가면 y의 행 +1 (증가)
	//위로 올라가면 y의 행 -1 (감소)
	static int d = 0, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 1;
		}


		L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			dir.put(X, C);
		}

		move();

	}

	static void move() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		int nowX = 0, nowY = 0;

		while (true) {
			cnt++;
			nowX += dx[d];
			nowY += dy[d];

			if (nowX < 0 || nowY < 0 || nowX >= N || nowY >= N || map[nowY][nowX] == 2) {
				break;
			}

			//행:y, 열:x
			if (map[nowY][nowX] == 1) { //사과 먹으면 동으로 가면 그대로 방향 유지
				q.add(new int[] {nowX, nowY});
			} else { //사과 없으면 꼬리 있는 칸 제거
				int tail[] = q.poll(); //꼬리 아웃
				map[tail[1]][tail[0]] = 0;
				q.add(new int[] {nowX, nowY});
			}

			//뱀이 위치하고 있는 곳은 2로 채운다.
			map[nowY][nowX] = 2;

			if (dir.containsKey(cnt)) {
				if (dir.get(cnt).equals("D")) {
					d++;
					if (d == 4) d = 0;
				} else {
					d--;
					if (d == -1) d = 3;
				}
			}
		}

		System.out.println(cnt);

	}

}