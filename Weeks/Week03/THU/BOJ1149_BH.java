import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][3];
        int[][] sum = new int[N + 1][3];

        int idx = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + arr[i][0];
            sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + arr[i][1];
            sum[i][2] = Math.min(sum[i - 1][0], sum[i - 1][1]) + arr[i][2];
        }

        // for (int[] s : sum) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        System.out.println(Math.min(sum[N][0], Math.min(sum[N][1], sum[N][2])));
    }
}
