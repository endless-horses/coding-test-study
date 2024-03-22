import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String regex = br.readLine();
        int m = Integer.parseInt(br.readLine());

        LinkedList<Character> editor = new LinkedList<>();

        for (char c : regex.toCharArray()) {
            editor.add(c);
        }

        ListIterator<Character> iter = editor.listIterator();

        // cursor 젤 마지막으로 이동
        while (iter.hasNext()) { // 요소가 있을 때까지
            iter.next(); // cursor 이동
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L' : // cursor 왼쪽으로 한 칸 이동
                    if (iter.hasPrevious()) // cursor 앞에 요소 있음
                        iter.previous();
                    break;
                case 'D' :
                    if (iter.hasNext()) // cursor 뒤에 요소 있음
                        iter.next();
                    break;
                case 'B' :
                    if (iter.hasPrevious()) {
                        //remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거함
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P' :
                    char t = command.charAt(2); // 공백이 1
                    iter.add(t);

                    break;
                default :
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : editor) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}