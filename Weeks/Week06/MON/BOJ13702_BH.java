import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13702_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long max = arr[arr.length - 1];
        long min = 1;
        long middle = 0;

        while (max >= min) {
            int count = 0;
            middle = (max + min) / 2;

            for (int i = 0; i < N; i++) {
                count += arr[i] / middle;
            }

            // System.out.println("카운트: " + count + " 최대: " + max + " 최소: " + min + " 중간: "
            // + middle);
            if (count >= K) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }

            // if (count == K) {
            // answer = Math.max(answer, middle);
            // }
        }
        System.out.println(max);
    }
}
