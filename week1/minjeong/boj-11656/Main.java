import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        char[] array = S.toCharArray();
        String[] words = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            words[i] = new String(array, i, array.length - i);
        }

        Arrays.sort(words);

        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}