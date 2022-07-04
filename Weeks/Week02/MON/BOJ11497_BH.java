import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11497_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sort_list = new ArrayList<>();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            int max = list.get(list.size() - 1);
            Deque<Integer> deq = new LinkedList<>();
            deq.add(max);

            for (int k = list.size() - 2; k >= 0; k = k - 2) {
                if (k >= 0) {
                    deq.addFirst(list.get(k));
                }
            }

            for (int k = list.size() - 3; k >= 0; k = k - 2) {
                if (k >= 0) {
                    deq.addLast(list.get(k));
                }
            }

            while (!deq.isEmpty()) {
                sort_list.add(deq.peek());
                deq.pollFirst();
            }

            int answer = Integer.MIN_VALUE;
            for (int w = 0; w < N - 1; w++) {
                answer = Math.max(answer, Math.abs(sort_list.get(w) - sort_list.get(w + 1)));
            }

            if (answer == Integer.MIN_VALUE) {
                bw.write("-1" + "\n");
            } else {
                bw.write(answer + "\n");
            }

            answer = Integer.MIN_VALUE;
            sort_list.clear();
            deq.clear();
            list.clear();
        }

        bw.flush();
        bw.close();
    }
}
