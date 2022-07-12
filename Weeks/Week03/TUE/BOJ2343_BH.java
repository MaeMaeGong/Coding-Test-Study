import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2343_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        int max_num = Integer.MIN_VALUE;
        for (int i : arr) {
            if (max_num < i) {
                max_num = i;
            }
        }

        int max = sum;
        int min = max_num;
        int middle = 0;
        // System.out.println(max + " " + min);
        if (M != 1) {
            while (max >= min) {
                middle = (max + min) / 2;

                int cnt = 0;
                int sum2 = 0;
                for (int i = 0; i < N; i++) {
                    if (sum2 + arr[i] > middle) {
                        cnt += 1;
                        sum2 = 0;
                    }
                    sum2 += arr[i];
                }

                if (sum2 != 0) {
                    cnt += 1;
                }

                if (cnt <= M) {
                    max = middle - 1;
                } else {
                    min = middle + 1;
                }
                // System.out.println(middle + " " + cnt);
            }
            System.out.println(min);
        } else {
            System.out.println(max);
        }
    }
}
