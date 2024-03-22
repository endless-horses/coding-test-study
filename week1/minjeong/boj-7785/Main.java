import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> names = new HashSet<>();
        String k;
        String v;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            k = st.nextToken();
            v = st.nextToken();
            map.put(k, v);
            names.add(k);
        }

        for (String name : names) {
            if (Objects.equals(map.get(name), "leave"))
                map.remove(name);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, Collections.reverseOrder());

        for (String key : keySet) {
            sb.append(key).append("\n");
        }

        System.out.println(sb);
    }
}