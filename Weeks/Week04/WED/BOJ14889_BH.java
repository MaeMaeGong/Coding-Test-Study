import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889_BH {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BackTracking(1, 0);
        System.out.println(min);
    }

    public static void BackTracking(int start, int depth) {

        if (depth == N / 2) {
            diff();
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BackTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int S_team = 0;
        int L_team = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    S_team += arr[i][j];
                    S_team += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    L_team += arr[i][j];
                    L_team += arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(S_team - L_team));
        // System.out.println(S_team + " " + L_team);
    }
}
