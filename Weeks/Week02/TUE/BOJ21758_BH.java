import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ21758_BH {
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static int[] bee;
    static int[] Right_total_sum;
    static int[] Left_total_sum;
    static int honey_total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        bee = new int[N];
        Right_total_sum = new int[N];
        Left_total_sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bee[i] = Integer.parseInt(st.nextToken());
        }

        int temp1 = 0;
        for (int i = 0; i < N; i++) {
            temp1 += bee[i];
            Right_total_sum[i] = temp1;
        }

        honey_total = Right_total_sum[Right_total_sum.length - 1];

        int temp2 = 0;
        for (int i = N - 1; i >= 0; i--) {
            temp2 += bee[i];
            Left_total_sum[i] = temp2;
        }
        if (N > 3) {
            case1();// 맨 왼쪽 벌1, 맨 오른쪽에 꿀통, 그 외 위치 벌2
            case2();// 맨 왼쪽 꿀통, 맨 오른쪽 벌1, 그외 위치 벌2
            case3();// 중간 꿀통, 양쪽 끝 벌1~2
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        } else {
            int answer = 0;
            for (int i = 0; i < N; i++) {
                if (answer < bee[i]) {
                    answer = bee[i];
                }
            }
            System.out.println(answer * 2);
        }
    }

    public static void case1() {
        int bee1;
        int bee2;
        int max = 0;
        for (int i = 1; i < N - 2; i++) {
            bee1 = honey_total - bee[0] - bee[i];
            bee2 = honey_total - Right_total_sum[i];
            max = Math.max(max, bee1 + bee2);
        }
        list.add(max);
    }

    public static void case2() {
        int bee1;
        int bee2;
        int max = 0;
        for (int i = N - 2; i > 0; i--) {
            bee1 = honey_total - bee[N - 1] - bee[i];
            bee2 = honey_total - Left_total_sum[i];
            max = Math.max(max, bee1 + bee2);
        }
        list.add(max);
    }

    public static void case3() {
        int[] honey = new int[N - 2];
        for (int i = 1; i < N - 1; i++) {
            honey[i - 1] = Right_total_sum[i] - Right_total_sum[0];
        }

        for (int i = 1; i < N - 1; i++) {
            honey[i - 1] += (Left_total_sum[i] - Left_total_sum[N - 1]);
        }

        Arrays.sort(honey);
        list.add(honey[honey.length - 1]);
    }

}