import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2138_BH {

    static String[] bulb;
    static String[] change;

    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        bulb = new String[N];
        change = new String[N];

        String word = br.readLine();
        for (int i = 0; i < N; i++) {
            bulb[i] = word.substring(i, i + 1);
        }

        String c_word = br.readLine();
        for (int i = 0; i < N; i++) {
            change[i] = c_word.substring(i, i + 1);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!bulb[i].equals(change[i])) {
                if (i == 0) {
                    cnt++;
                }

                if (cnt == 1) {
                    L_Change(i);
                } else {
                    R_Change(i);
                }
            }
        }
        System.out.println(answer + 1);

    }

    static void R_Change(int a) {
        answer++;
        if (a != N - 1 && a + 1 <= N) {
            for (int i = a; i < a + 2; i++) {
                if (bulb[i].equals("0")) {
                    bulb[i] = "1";
                } else {
                    bulb[i] = "0";
                }
            }
        } else {
            for (int i = a; i > a - 1; i--) {
                if (bulb[i].equals("0")) {
                    bulb[i] = "1";
                } else {
                    bulb[i] = "0";
                }
            }
        }
    }

    static void L_Change(int a) {
        answer++;
        if (a != 0 && a - 1 >= N) {
            for (int i = a; i > a - 2; i--) {
                if (bulb[i].equals("0")) {
                    bulb[i] = "1";
                } else {
                    bulb[i] = "0";
                }
            }
        } else {
            for (int i = a; i < a + 1; i++) {
                if (bulb[i].equals("0")) {
                    bulb[i] = "1";
                } else {
                    bulb[i] = "0";
                }
            }
        }
    }
}
