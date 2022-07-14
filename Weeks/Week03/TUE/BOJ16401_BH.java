import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ16401_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int max = arr[N - 1];
        int min = 1;
        int middle = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] / 1 >= 1) {
                cnt += arr[i] / 1;
            }
        }
        // System.out.println(cnt);
        if (cnt >= M) {
            while (max >= min) {

                middle = (max + min) / 2;

                cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] / middle >= 1) {
                        cnt += arr[i] / middle;
                    }
                }

                if (cnt >= M) {
                    list.add(middle);
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
                // System.out.println(middle + " " + cnt);
            }
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        } else {
            System.out.println("0");
        }
    }

}