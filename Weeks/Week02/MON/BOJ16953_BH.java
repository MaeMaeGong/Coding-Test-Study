import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953_BH {
    static long A, B;

    static int answer = 0;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(A, B, 0);
        if (answer == 0) {
            System.out.println("-1");
        } else {
            System.out.println(answer + 1);
        }
    }

    public static void dfs(long start, long target, int count) {
        if (start != target) {
            String plusOne = String.valueOf(start) + "1";
            if (Long.parseLong(plusOne) <= target) {
                dfs(Long.parseLong(plusOne), target, count + 1);
            }
            if (start * 2 <= target) {
                dfs(start * 2, target, count + 1);
            }
        } else {
            answer = count;
            return;
        }
    }
}
