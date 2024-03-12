import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(String.valueOf(c));
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                set.add(s.substring(j, j+i+1));
            }
        }

        System.out.println(set.size());
    }
}