import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055_BH {

    static int N;
    static int K;
    static int[] arr;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        robot = new boolean[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        while (true) {
            int count = 0;
            // 1. 컨베이어벨트 + 로봇 같이 움직임
            moveBelt();

            // 2. 로봇 한칸씩 이동
            moveRobot();

            // 3. 로봇 올리기
            plusRobot();
            for (int i = 0; i < 2 * N; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            if (count >= K) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    public static void moveBelt() {
        int temp = arr[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

        for (int i = N - 2; i >= 0; i--) {
            if (robot[i]) {
                if (i == N - 2) {
                    if (robot[i]) {
                        robot[i] = false;
                    }
                } else {
                    if (!robot[i + 1]) {
                        robot[i] = false;
                        robot[i + 1] = true;
                    }
                }
            }
        }
    }

    public static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i]) {
                if (i == N - 2) {
                    if (arr[i + 1] > 0 && !robot[i + 1]) {
                        robot[i] = false;
                        arr[i + 1]--;
                    }
                } else {
                    if (arr[i + 1] > 0 && !robot[i + 1]) {
                        robot[i] = false;
                        robot[i + 1] = true;
                        arr[i + 1]--;
                    }
                }
            }
        }
    }

    public static void plusRobot() {
        if (arr[0] != 0) {
            robot[0] = true;
            arr[0]--;
        }
    }
}
