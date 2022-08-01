import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ6236_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();

        int[] arr = new int[N];
        int sum = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        long max = 1000000000;
        long middle = 0;

        while (max >= min) {
            middle = (max + min) / 2;

            long money = middle;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (arr[i] > money) {

                }
                money = money - arr[i];
            }

            if (cnt > M) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        System.out.println(min);
    }
}
