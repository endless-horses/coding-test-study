import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int last = s.length();

		LinkedList<String> list = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			list.add(s.substring(i, last));
		}

		Collections.sort(list);

		for (String l : list) {
			System.out.println(l);
		}

	}
}