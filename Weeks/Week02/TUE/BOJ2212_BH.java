import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] senser = new int[N];
        int[] dist = new int[N - 1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            senser[i] = Integer.parseInt(st.nextToken());
        }

        if (N == K) {
            System.out.println(answer);
        } else {
            Arrays.sort(senser);
            for (int i = 0; i < N - 1; i++) {
                dist[i] = Math.abs(senser[i] - senser[i + 1]);
            }
            Arrays.sort(dist);
            for (int i = 0; i < N - 1 - (K - 1); i++) {
                answer += dist[i];
            }
            System.out.println(answer);
        }
    }
}
