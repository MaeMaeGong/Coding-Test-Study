import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2110_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = arr[N - 1] - arr[0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (min > Math.abs(arr[i] - arr[i + 1])) {
                min = Math.abs(arr[i] - arr[i + 1]);
            }
        }
        int middle = 0;
        int answer = 0;
        while (max >= min) {
            middle = (max + min) / 2;

            int cnt = 1;// 공유기 설치
            int start = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - start >= middle) {
                    cnt++;
                    start = arr[i];
                }
            }
            // System.out.println("공유기 갯수: " + cnt + "" + " 최소 : " + min + " 최대 : " + max +
            // " 중간 : " + middle);

            if (cnt >= C) {
                answer = middle;
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
