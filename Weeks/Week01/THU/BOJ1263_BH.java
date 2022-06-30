import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1263_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(time, (a, b) -> {
            return b[0] - a[0];
        });

        Arrays.sort(time, (a, b) -> {
            return b[1] - a[1];
        });

        int start_time = time[0][1] - time[0][0];
        int cnt = 0;
        for (int i = 1; i < N; i++) {

            if (time[i][1] < start_time) {
                start_time = time[i][1];
            }
            start_time -= time[i][0];
            // System.out.print(start_time + " ");
        }

        if (start_time > 0) {
            System.out.println(start_time);
        } else {
            System.out.println("-1");
        }
    }
}
