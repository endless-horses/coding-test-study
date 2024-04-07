import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> idxStack = new Stack<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) { // 배열의 길이만큼 순회
            while (!idxStack.empty() && result[idxStack.peek()] < result[i]) {
                result[idxStack.peek()] = result[i];
                idxStack.pop();
            }
            idxStack.push(i); // 수열을 저장하는 배열의 index를 추가
        }

        while (!idxStack.empty()) {
            result[idxStack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}