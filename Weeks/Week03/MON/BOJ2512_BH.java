import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2512_BH {

    static int max, min, middle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int s : budget) {
            sum += s;
        }

        Arrays.sort(budget);

        ArrayList<Integer> list = new ArrayList<>();

        if (sum > M) {
            max = budget[N - 1];
            min = 0;
            middle = 0;

            while (max >= min) {
                middle = (max + min) / 2;
                int bud = 0;
                for (int i = 0; i < N; i++) {
                    if (middle >= budget[i]) {
                        bud += budget[i];
                    } else {
                        bud += middle;
                    }
                }
                if (bud <= M) {
                    list.add(middle);
                }
                if (bud > M) {
                    max = middle - 1;
                } else {
                    min = middle + 1;
                }

            }
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        } else {
            System.out.println(budget[N - 1]);
        }
    }
}
