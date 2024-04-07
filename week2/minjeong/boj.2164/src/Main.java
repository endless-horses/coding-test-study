import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> cards = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            cards.addLast(i);
        }

        while (cards.size() > 1) {
            cards.pollFirst();
            cards.addLast(cards.pollFirst());
        }

        System.out.println(cards.pollFirst());
    }
}