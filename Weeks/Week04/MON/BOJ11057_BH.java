import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11057_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] answer = new int[N][10];
        int count = 0;
        if (N > 0) {
            for (int i = 0; i < 10; i++) {
                answer[0][i] = 1;
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    int temp = 0;
                    for (int k = 0; k <= j; k++) {
                        temp += (answer[i - 1][k] % 10007);
                        answer[i][j] = temp % 10007;
                    }
                }
            }
            int ss = 0;
            for (int i = 0; i < 10; i++) {
                ss += (answer[N - 1][i] % 10007);
                count = ss % 10007;
            }
        }

        // for (int[] s : answer) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }

        System.out.println(count);
    }
}

// 1 1 1 1 1 1 1 1 1 1
// 1 2 3 4 5 6 7 8 9 10
// 1 3 6 .. 55
