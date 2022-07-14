import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1904_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }

        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        System.out.println(arr[N - 1]);
    }
}
