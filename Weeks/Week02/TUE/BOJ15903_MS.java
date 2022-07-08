import java.util.*;
import java.io.*;

public class BOJ15903_MS {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Long.parseLong((st.nextToken())));

        }

        for (int i=0; i < m; i ++) {
            
            long t1 = queue.poll();
            long t2 = queue.poll();

            long sum = t1 + t2;

            queue.offer(sum);
            queue.offer(sum);
        }

        long sum = 0;

        while(!queue.isEmpty()) {
            sum += queue.poll();    
        }

        System.out.println(sum);
    }
}
