import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M;
        HashMap<String, Integer> map;

        StringTokenizer st;
        String type;

        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                type = st.nextToken();

                if (map.containsKey(type)) {
                    map.put(type, map.get(type)+1);
                }
                else {
                    map.put(type, 1);
                }
            }

            int result = 1;
            for (int v : map.values()) {
                result *= (v+1);
            }

            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}