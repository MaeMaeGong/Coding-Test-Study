import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class BOJ1654_BH {

    static long max, min, middle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        max = lan[K - 1];
        min = 1;
        middle = 0;

        while (max >= min) {
            middle = (max + min) / 2;
            int count = 0;
            for (int i = 0; i < K; i++) {
                count += (lan[i] / middle);
            }

            if (count < N) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }

        System.out.println(max);
    }
}
