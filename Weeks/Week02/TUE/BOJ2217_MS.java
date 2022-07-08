import java.util.*;
import java.io.*;

public class BOJ2217_MS {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int min = queue.poll();
            int len = queue.size();
            
            int temp = min*(len+1);
            if (max < temp) max = temp;
        }

        System.out.println(max);      
    }
}
