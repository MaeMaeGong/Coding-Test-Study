import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.RunElement;

public class BOJ2529_BH {

    static int k;
    static String[] mark;
    static boolean[] visited;
    static String answer = "";
    static int depth = 0;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mark = new String[k];
        visited = new boolean[10];

        for (int i = 0; i < k; i++) {
            mark[i] = st.nextToken();
        }

        backtracking(depth, 0, answer);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    public static void backtracking(int depth, int now, String answer) {

        if (depth == k + 1) {
            list.add(answer);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth > 0) {
                    if (mark[depth - 1].equals("<")) {
                        if (now > i) {
                            continue;
                        }
                    } else {
                        if (now < i) {
                            continue;
                        }
                    }
                }
                visited[i] = true;
                backtracking(depth + 1, i, answer + Integer.toString(i));
                visited[i] = false;
            }
        }
    }
}
