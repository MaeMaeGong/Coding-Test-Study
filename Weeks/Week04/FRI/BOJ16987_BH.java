import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987_BH {

    static int depth = 0;
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int[] s : arr) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        BackTracking(0);
    }

    public static void BackTracking(int depth) {
        if (depth == 2) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {

                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
