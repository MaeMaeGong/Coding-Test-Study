import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int circle = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] grade = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    grade[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(grade, (a, b) -> {
                return a[0] - b[0];
            });

            int standard = grade[0][1];
            int count = 1;

            for (int i = 1; i < N; i++) {
                if (standard > grade[i][1]) {
                    standard = grade[i][1];
                    count++;
                }

                if (grade[i][1] == 1) {
                    break;
                }
            }

            circle++;
            bw.write(count + "\n");
            if (circle == T) {
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
