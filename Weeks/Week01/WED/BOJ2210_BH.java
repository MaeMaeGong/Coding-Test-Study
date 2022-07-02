import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2210_BH {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static String[][] map = new String[5][5];
    static boolean[][] visited = new boolean[5][5];

    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                String word = "";
                word += map[a][b];
                dfs(a, b, word);
            }
        }
        bw.write(answer.size() + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c, String word) {

        if (word.length() == 6) {
            if (!answer.contains(word)) {
                answer.add(word);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5) {
                    dfs(nr, nc, word + map[nr][nc]);
                }
            }
        }
    }
}