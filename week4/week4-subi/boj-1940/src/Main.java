import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int needNum = Integer.parseInt(br.readLine());
		int[] uniqueNum = new int[num];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			uniqueNum[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(uniqueNum);

		int startIndex = 0, endIndex = num - 1, count = 0;

		for (int i = 0; i < uniqueNum.length; i++) {
			while (startIndex < endIndex) {
				int sum = uniqueNum[startIndex] + uniqueNum[endIndex];
				if (sum > needNum) {
					endIndex--;
				} else if (sum < needNum) {
					startIndex++;
				} else {
					count++;
					endIndex--;
					startIndex++;
				}
			}
		}

		System.out.println(count);


	}
}
