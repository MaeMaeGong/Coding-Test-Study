import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Balloon> deque = new ArrayDeque();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.addLast(new Balloon(Integer.parseInt(st.nextToken()), i));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.peekFirst().loc + " ");
            int temp = deque.pollFirst().num;
            if (deque.isEmpty())
                break;
            if (temp > 0) {
                for (int j = 0; j < temp - 1; j++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int j = 0; j < Math.abs(temp); j++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb.toString());
    }

    static class Balloon {
        int num, loc;

        public Balloon(int num, int loc) {
            this.num = num;
            this.loc = loc;
        }
    }
}
