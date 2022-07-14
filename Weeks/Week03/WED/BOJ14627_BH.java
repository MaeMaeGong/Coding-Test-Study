import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14627_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] arr = new long[S];
        long sum = 0;
        for (int i = 0; i < S; i++) {
            arr[i] = Long.parseLong(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        long min = 1;
        long max = 1000000000;
        long middle = 0;

        while (max >= min) {
            middle = (max + min) / 2;

            long cnt = 0;
            for (int i = 0; i < S; i++) {
                if (arr[i] / middle > 0) {
                    cnt = cnt + arr[i] / middle;
                }
            }

            // System.out.println(cnt + " " + " 최소 : " + min + " 최대 : " + max + " 중간 : " +
            // middle);

            if (cnt < C) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }

        }
        // System.out.println(middle);
        long answer = 0;

        // for (int i = 0; i < S; i++) {
        // answer += (arr[i] % max);
        // }
        // System.out.println(answer);// 440 % 175 = 90
        // System.out.println(sum - max * C);
    }
}
