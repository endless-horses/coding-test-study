package week1.jinwoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2910 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(n);
        List<Integer> origin = new ArrayList<>(n);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            origin.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(list, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return origin.indexOf(o1) - origin.indexOf(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);
    }
}
