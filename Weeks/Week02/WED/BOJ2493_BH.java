import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] laser = new int[N];
        int[] answer = new int[N];
        Stack<Laser> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            laser[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                answer[i] = 0;
                stack.push(new Laser(laser[i], i + 1));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        answer[i] = 0;
                        stack.push(new Laser(laser[i], i + 1));
                        break;
                    }

                    if (stack.peek().height > laser[i]) {
                        answer[i] = stack.peek().num;
                        stack.push(new Laser(laser[i], i + 1));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Laser {
        int height, num;

        public Laser(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
}
