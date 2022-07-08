import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] guitar = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                guitar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack<Integer>[] stack = new Stack[7];

        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (stack[guitar[i][0]].isEmpty()) {
                stack[guitar[i][0]].add(guitar[i][1]);
                answer++;
            } else {
                if (stack[guitar[i][0]].peek() < guitar[i][1]) {
                    stack[guitar[i][0]].add(guitar[i][1]);
                    answer++;
                } else {
                    while (true) {
                        if (stack[guitar[i][0]].isEmpty()) {
                            stack[guitar[i][0]].add(guitar[i][1]);
                            answer++;
                            break;
                        }
                        if (stack[guitar[i][0]].peek() < guitar[i][1]) {
                            stack[guitar[i][0]].add(guitar[i][1]);
                            answer++;
                            break;
                        } else if (stack[guitar[i][0]].peek() == guitar[i][1]) {
                            // answer++;
                            break;
                        }
                        stack[guitar[i][0]].pop();
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
