import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18115_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        Deque<Integer> deq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int k = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (card[i] == 1) {
                deq.addFirst(k);
            } else if (card[i] == 2) {
                int temp = deq.pollFirst();
                deq.addFirst(k);
                deq.addFirst(temp);
            } else {
                deq.addLast(k);
            }
            k++;
        }
        for (int i = 0; i < N; i++) {
            bw.write(deq.poll() + " ");
        }
        bw.flush();
        bw.close();
    }
}
