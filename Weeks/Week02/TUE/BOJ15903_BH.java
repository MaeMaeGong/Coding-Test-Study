import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 카드 갯수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수

        long[] card = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Long.parseLong(st.nextToken());
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(card[i]);
        }

        for (int i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();
            long sum = x + y;
            queue.add(sum);
            queue.add(sum);
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}
