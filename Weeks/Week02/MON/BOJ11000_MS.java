import java.io.*;
import java.util.*;

class Times implements Comparable<Times> {

    public int s, t;
    Times (int s, int t) {
        this.s = s;
        this.t = t;
    }
    @Override
    public int compareTo(Times o) {
        if(this.s == o.s) return this.t-o.t;
        else return this.s-o.s;
    }
}

public class BOJ11000_MS {
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    // 수업 갯수

        StringTokenizer st;

        ArrayList<Times> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list.add(new Times(s, t));
        }

        Collections.sort(list);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        int count = 0;
        int end = 0;

        for (Times time : list) {

            int len = priorityQueue.size();

            if (!priorityQueue.isEmpty()) {
                if (priorityQueue.peek() <= time.s) {
                    priorityQueue.poll();
                    priorityQueue.offer(time.t);
                }
                else {
                    count++;
                    priorityQueue.offer(time.t);
                }
            }
            
            if (len == 0) {
                count++;
                priorityQueue.offer(time.t);
            }
        }

        System.out.println(count);
    }
}
