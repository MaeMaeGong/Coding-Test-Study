import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_BH {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // int idx = 0;
        int sum = 0;
        for (int i = 1; i < m - 1; i++) {
            int left_max = 0;
            int right_max = 0;
            // 현재 인덱스 기준 왼쪽에서 가장 높은 것.(현재 인덱스 값 보다 커야함)
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= left_max) {
                    left_max = arr[j];
                }
            }
            // 현재 인덱스 기준 오른쪽에서 가장 높은 것.(현재 인덱스 값 보다 커야함)
            for (int j = i + 1; j < m; j++) {
                if (arr[j] >= right_max) {
                    right_max = arr[j];
                }
            }
            int temp = 0;
            // 둘중 작은것 선택
            if (arr[i] < n) {
                // if (right_max == left_max && right_max == 0) {
                // continue;
                // }
                if (left_max < right_max) {
                    temp = left_max;
                } else {
                    temp = right_max;
                }
                if (temp == 0) {
                    continue;
                }
                if (temp <= arr[i]) {
                    continue;
                }
                // 작은거 - 현재 인덱스 값.
                sum += temp - arr[i];
                // System.out.println(
                // "현재 높이: " + arr[i] + " 왼쪽: " + left_max + " 오른쪽: " + right_max + " 둘중작은것: " +
                // temp + " 빗물양: "
                // + sum);
            }
        }
        System.out.println(sum);
    }
}
