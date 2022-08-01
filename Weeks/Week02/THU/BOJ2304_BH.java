import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2304_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] roof = new int[N][2];
        Stack<Area> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                roof[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(roof, (a, b) -> {
            return a[0] - b[0];
        });

        System.out.println();
        for (int[] s : roof) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }

        // 최대 높이 구하기
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < roof[i][1]) {
                max = roof[i][1];
            }
        }

        int k = 0;
        int answer = 0;
        int idx1 = 0;
        // 왼쪽부터
        while (true) {
            if (roof[k][1] != max) {
                if (roof[idx1][1] < roof[k + 1][1]) {
                    list.add((roof[k + 1][0] - roof[idx1][0]) * roof[idx1][1]);
                    idx1 = k + 1;
                    k++;
                } else {
                    k++;
                }
            } else {
                break;
            }
        }

        // 오른쪽부터

        for (int s : list) {
            System.out.print(s + " ");
        }
        // System.out.println(answer);
    }

    static class Area {
        int x, y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}