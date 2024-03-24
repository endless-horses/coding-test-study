import java.io.*;
import java.util.PriorityQueue;

class MaxHeap implements Comparable<MaxHeap> {
	int num;

	public MaxHeap(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(MaxHeap m) {
		return m.num - this.num; //내림차순 (1,2 들어오면 2부터 poll)
	}

	//bw쓸꺼면 toString 함수 오버라이드 필요
	public String toString() {
		return String.valueOf(num);
	}
}

public class Main {

	static PriorityQueue<MaxHeap> PQ = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			switch (input) {
				case 0:
					if (PQ.isEmpty()) {
						bw.write(0 + "\n");
						break;
					}
					bw.write(PQ.poll() + "\n");
					break;
				default:
					PQ.add(new MaxHeap(input));
					break;
			}

			bw.flush();
		}

		bw.close();

	}

}