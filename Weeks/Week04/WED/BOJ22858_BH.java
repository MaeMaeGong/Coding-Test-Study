import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ22858_BH {

    static int N, K;
    static int[] arrS;
    static int[] arrD;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arrS = new int[N + 1];
        arrD = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arrS[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arrD[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            change();
        }

        for (int i = 1; i <= N; i++) {
            bw.write(arrS[i] + " ");
        }
        bw.flush();
        bw.close();

    }

    public static void change() {
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            answer[arrD[i]] = arrS[i];
        }
        arrS = answer;
    }
}
