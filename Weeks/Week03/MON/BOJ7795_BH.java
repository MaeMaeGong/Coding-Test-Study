import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_BH {
    static int max, min, middle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int count = 0;
            int temp = 0;
            int result = 0;
            for (int i = 0; i < N; i++) {
                count = 0;
                max = M - 1;
                min = 0;
                middle = 0;
                while (max >= min) {
                    temp = A[i];
                    middle = (max + min) / 2;
                    if (B[middle] < temp) {
                        min = middle + 1;
                        count = middle + 1;
                    } else {
                        max = middle - 1;
                    }
                }
                result += count;
            }

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
