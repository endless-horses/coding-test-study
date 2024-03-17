package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> employee = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter")) {
                employee.put(name, true);
            } else if (cmd.equals("leave")) {
                employee.remove(name);
            }
        }

        List<String> list = new ArrayList<>(employee.keySet());
        Collections.sort(list);
        Collections.reverse(list);
        for (String name : list) {
            System.out.println(name);
        }
    }
}
