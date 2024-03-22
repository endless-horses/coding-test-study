import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum;

        int[][] arrays = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arrays[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());

        int i;
        int j;
        int x;
        int y;

        for (int r = 0; r < k; r++) {
            st = new StringTokenizer(br.readLine(), " ");

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sum = 0;

            for (int col = j-1; col < y; col++) {
                for (int row = i-1; row < x; row++) {
                    sum += arrays[row][col];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}