import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.text.html.HTML;

public class BOJ3020_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = H;
        int min = 1;
        int middle = 0;

        int min_value = Integer.MAX_VALUE;
        int answer = 0;

        while (max >= min) {
            middle = (max + min) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    if (middle <= arr[i]) {
                        cnt++;
                    }
                } else {
                    if (middle > H - arr[i]) {
                        cnt++;
                    }
                }
            }

            if (cnt <= min_value) {
                if (!list.contains(middle)) {
                    list.add(middle);
                    answer++;
                    min_value = cnt;
                } else {
                    answer++;
                }
            }
            System.out.println("최댓값: " + max + " 최솟값: " + min + " 중간값: " + middle + " cnt: " + cnt);
            if (cnt >= (N / 2)) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
            // System.out.println(cnt);
        }
        System.out.println();
        max = H;
        min = 1;
        middle = 0;
        min_value = Integer.MAX_VALUE;
        while (max >= min) {
            middle = (max + min) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    if (middle <= arr[i]) {
                        cnt++;
                    }
                } else {
                    if (middle > H - arr[i]) {
                        cnt++;
                    }
                }
            }
            if (cnt <= min_value) {
                if (!list.contains(middle)) {
                    list.add(middle);
                    answer++;
                    min_value = cnt;
                }
            }

            System.out.println("최댓값: " + max + " 최솟값: " + min + " 중간값: " + middle + " cnt: " + cnt);
            if (cnt < min_value) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
            // System.out.println(cnt);
        }
        Collections.sort(list);
        System.out.println(list.get(0) + " " + answer);
    }
}
