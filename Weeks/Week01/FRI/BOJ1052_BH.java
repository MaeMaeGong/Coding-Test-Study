import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1052_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (true) {
            int num = N;
            int cnt = 0;
            while (num != 0) {
                if (num % 2 != 0) {
                    cnt += 1;// 추가해야 하는 물병의 갯수
                }
                num = num / 2;
            }
            // System.out.println(cnt);

            if (cnt <= K) {
                break;
            }

            answer += 1; // 물병 한개 추가
            N += 1;// 최적값을 구하기 위해 N값을 증가시킨다.
        }
        System.out.println(answer);
    }
}
