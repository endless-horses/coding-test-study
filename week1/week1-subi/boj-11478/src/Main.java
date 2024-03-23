import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				set.add(input.substring(i, j));
			}
		}

		bw.write(String.valueOf(set.size()));
		bw.flush();
		bw.close();

	}
}