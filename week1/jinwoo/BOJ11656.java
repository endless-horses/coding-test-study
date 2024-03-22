package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11656 {
    static List<String> dict = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            dict.add(str.substring(i, str.length()));
        }
        Collections.sort(dict);
        for (String word : dict) {
            System.out.println(word);
        }
    }
}
