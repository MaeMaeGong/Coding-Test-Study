import java.io.*;
import java.util.*;

public class BOJ16953_MS {

    static int L=1;
    static long[] ch;

    public static void bfs (long A, long B) {

        ArrayList<Long> ch = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();

        queue.offer(A);
        ch.add(A);
        
        while(!queue.isEmpty()) {

            int len = queue.size();
            
            if (queue.contains(B)) {
                return;
            }
            for (int i = 0; i < len; i ++) {
                
                long temp = queue.poll();

                for (int j = 0; j < 2; j++) {
                    long cal = 0;
                    
                    if(j == 0) cal = temp * 2;                               
                    else cal = temp * 10 +1;
                    
                    if (cal == B) {
                        L++;
                        return;
                    }
                    
                    if (cal <= B/2 ) {
                        if (!ch.contains(cal)) {
                            ch.add(cal);
                            queue.offer(cal);
                        }
                    }
                }
            }
            L++;
        }
        L = -1;
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());   
        long B = Long.parseLong(st.nextToken());

        bfs(A,B);

        System.out.println(L);
    }
}
