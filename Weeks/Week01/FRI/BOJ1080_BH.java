import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080_BH {

    static int N, M;
    static int answer = 0;
    static int fal = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] matrix = new String[N][M];
        String[][] c_matrix = new String[N][M];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = word.substring(j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            String cword = br.readLine();
            for (int j = 0; j < M; j++) {
                c_matrix[i][j] = cword.substring(j, j + 1);
            }
        }

        if (N >= 3 && M >= 3) {
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (!matrix[i][j].equals(c_matrix[i][j])) {
                        Change(matrix, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!matrix[i][j].equals(c_matrix[i][j])) {
                    fal++;
                    break;
                }
            }
        }

        if (fal == 0) {
            System.out.println(answer);
        } else if (answer == 0) {
            System.out.println("-1");
        } else {
            System.out.println("-1");
        }
    }

    static void Change(String[][] matrix, int a, int b) {
        answer++;
        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (matrix[i][j].equals("0")) {
                    matrix[i][j] = "1";
                } else {
                    matrix[i][j] = "0";
                }
            }
        }
    }
}
