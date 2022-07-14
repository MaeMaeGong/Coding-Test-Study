import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9461_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // if (N > 2) {
            long[] arr = new long[101];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;

            for (int j = 3; j < N; j++) {
                arr[j] = arr[j - 3] + arr[j - 2];
            }

            bw.write(arr[N - 1] + "\n");
            // } else {
            // bw.write(1 + "\n");
            // }
        }
        bw.flush();
        bw.close();
    }
}
