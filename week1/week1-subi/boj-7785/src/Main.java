import java.io.*;
import java.util.*;

public class Main {

	static Map<String, String> map = new HashMap<>();
	static ArrayList<String> A = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String log = st.nextToken();

			switch (log) {
				case "enter":
					map.put(name, "enter");
					break;
				case "leave":
					map.put(name, "leave");
					break;
			}

		}

		for (String key : map.keySet()) {
			if (map.get(key).equals("enter")) {
				A.add(key);
			}
		}

		Collections.sort(A, Collections.reverseOrder());

		for (String s : A) {
			bw.write(s + "\n");
		}

		bw.flush();
		bw.close();

	}
}