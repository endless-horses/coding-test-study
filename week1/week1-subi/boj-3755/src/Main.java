import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Client implements Comparable<Client> {
	int name;
	int priority;

	public Client(int name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	@Override
	public int compareTo(Client other) {
		return other.priority - this.priority; //입력되는 숫자가 높으면 앞으로
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		//높은 숫자가 우선순위가 높은 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		PriorityQueue<Client> queue = new PriorityQueue<>();

		while (true) {

			String s = br.readLine();

			if (s.equals("0")) break;

			st = new StringTokenizer(s);
			int num = Integer.parseInt(st.nextToken());

			switch (num) {
				case 1:
					int k = Integer.parseInt(st.nextToken());
					int p = Integer.parseInt(st.nextToken());
					queue.add(new Client(k, p));
					break;
				case 2:
					if (queue.isEmpty()) {
						bw.write(0 + "\n");
						//System.out.println(0);
					} else {
						bw.write(queue.poll() + "\n");
						//System.out.println(queue.poll());
					}
					break;
				case 3:
					Client low = queue.peek(); //제일 앞에 있는 요소 (10,99)
					int min = low.priority; //가장 높은 숫자가 나온다. (99)
					if (queue.isEmpty()) {
						bw.write(0 + "\n");
						//System.out.println(0);
					} else {
						for (Client c : queue) {
							if (c.priority < min) {
								min = c.priority;
								low = c;
							}
						}
						bw.write(low.name + "\n");
						//System.out.println(low.name);
						queue.remove(low);
					}
					break;
			}

			bw.flush();
		}
		bw.close(); //while문에서 제한조건일 때 return을 써주지 않고 break를 써주면 close를 쓸 수 있다.
	}

}