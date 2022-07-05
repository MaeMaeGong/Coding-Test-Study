import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2217_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int cnt = 2;
        int max = rope[N - 1];
        if (rope.length == 1) {
            System.out.println(rope[0]);
        } else {
            for (int i = N - 2; i >= 0; i--) {
                if (max <= rope[i] * cnt) {
                    max = rope[i] * cnt;
                }
                cnt++;
            }
            System.out.println(max);
        }
    }
}
