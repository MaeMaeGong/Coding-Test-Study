import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> road = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            road.add(0);
        }

        int weight = 0;
        int time = 0;
        while (!road.isEmpty()) {
            time++;
            weight -= road.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + weight <= L) {
                    weight += truck.peek();
                    road.add(truck.poll());
                } else {
                    road.offer(0);
                }
            }
            // System.out.println(road);
        }
        System.out.println(time);
    }
}
