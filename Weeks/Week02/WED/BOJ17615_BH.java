import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17615_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String ball = br.readLine();
        int cnt = 1;
        String now_ball = ball.substring(0, 1);
        for (int i = 0; i < N; i++) {
            if (!now_ball.equals(ball.substring(i, i + 1))) {
                now_ball = ball.substring(i, i + 1);
                cnt++;
            }
        }
        System.out.println(cnt);
        if (cnt == 1 || cnt == 2) {
            System.out.println("0");
        } else if (cnt == 3) {
            System.out.println(cnt - 2);
        } else {
            System.out.println(cnt - 3);
        }
    }
}
