import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3079_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max = arr[N - 1] * 1000000000;
        long min = 0L;
        long middle = 0L;
        long answer = 0L;
        while (max >= min) {
            middle = (max + min) / 2;

            long cnt = 0L;
            for (int i = 0; i < N; i++) {
                cnt += middle / arr[i];
            }

            // System.out.println("최댓값: " + max + " 최솟값: " + min + " 중간값: " + middle + "
            // cnt: " + cnt);

            if (cnt >= M) {
                answer = middle;
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        System.out.println(answer);
    }
}
