import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                meeting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(meeting, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        // []안의 숫자는 배열의 인덱스 값을 의미한다. 즉 a[1]-b[1] = 배열의 두번째 값을 기준으로 정렬하는 람다식이다.
        // 첫번째 값과 두번째 값이 같은 경우는 아무 숫자 기준으로 정렬하면 된다. -> 두번째 값을 기준으로 풀 것이기 때문이다.

        int endTime = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (meeting[i][0] >= endTime) {
                endTime = meeting[i][1];
                max++;
            }
        }
        System.out.println(max);
    }
}
