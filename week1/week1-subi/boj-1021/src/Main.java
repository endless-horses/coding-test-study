import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0;
	static LinkedList<Integer> dequeue = new LinkedList<>();
	static ArrayList<Integer> A = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			dequeue.offer(i + 1);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			int targetIdx = dequeue.indexOf(A.get(i));
			int halfIdx;

			if (dequeue.size() % 2 == 0) {
				halfIdx = dequeue.size() / 2 - 1;
			} else {
				halfIdx = dequeue.size() / 2;
			}

			if (targetIdx <= halfIdx) {
				for (int j = 0; j < targetIdx; j++) {
					int tmp = dequeue.pollFirst();
					dequeue.offerLast(tmp);
					cnt++;
				}
			} else {
				for (int j = 0; j < dequeue.size() - targetIdx; j++) {
					int tmp = dequeue.pollLast();
					dequeue.offerFirst(tmp);
					cnt++;
				}
			}

			dequeue.pollFirst();

		}

		System.out.println(cnt);


	}
}