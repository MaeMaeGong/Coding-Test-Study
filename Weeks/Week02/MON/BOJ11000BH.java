import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<ClassRoom> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new ClassRoom(x, y));
        }

        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(list.get(0).end);

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= list.get(i).start) {
                queue.poll();
            }
            queue.add(list.get(i).end);
        }
        System.out.println(queue.size());
    }

    static class ClassRoom implements Comparable<ClassRoom> {
        int start, end;

        public ClassRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ClassRoom other) {
            if (this.start == other.start) {
                return this.end - other.end;
            } else {
                return this.start - other.start;
            }
        }
    }
}