import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int x;

        HashSet<Integer> set = new HashSet<>(A);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B; i++) {
            x = Integer.parseInt(st.nextToken());

            if (set.contains(x)) set.remove(x);
            else set.add(x);
        }

        System.out.println(set.size());
    }
}