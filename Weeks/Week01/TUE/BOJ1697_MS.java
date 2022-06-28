import java.util.*;
import java.io.*;

public class BOJ1697_MS {

    static int n, k, L=0;
    static int[] dis = {-1, 1, 2};
    static int[] ch = new int[200001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs() {

        queue.offer(n);
        ch[n] = 1; 
        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i=0; i < len; i++) {
                int x = queue.poll();
                for (int j=0; j < dis.length; j++) {
                    int pos;
                    if(dis[j] == 2) {
                        pos = x * dis[j];
                    }
                    else {
                        pos = x + dis[j];
                    }
                    
                    if(pos >= 0 && pos <= 100000 && ch[pos] == 0) {
                        ch[pos] = 1;
					    queue.offer(pos);
                    }
                } 
            }

            L++;

            if(queue.contains(k)) {
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 수빈 위치
        k = Integer.parseInt(st.nextToken());   // 동생 위치

        if(n == k) {
            System.out.println(0);
        }
        else {
            bfs();
            System.out.println(L);
        }
    }
}
