import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1912_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sum = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (sum[i] > max) {
                max = sum[i];
            }
        }

        System.out.println(max);
    }
}
