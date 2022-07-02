import java.util.*;
import java.io.*;

public class BOJ11060_MS {
    
    static int n, L=0;
    static List ch = new ArrayList<>();
    static Queue<List> queue = new LinkedList<>();

    static ArrayList<ArrayList<Integer>> miro;

    public static void bfs () {

        queue.offer(miro.get(0));
        ch.add(miro.get(0));
        
        while(!queue.isEmpty()) {
            int len = queue.size();

            if(queue.contains(miro.get(n-1))) return;

            for(int i =0; i < len; i++) {
                List temp = queue.poll();

                int in = (int) temp.get(0);
                int val = (int) temp.get(1);

                int start = in+1;
                int end = in+1+val;

                if (end >= n) end = n;

                for(int j = start; j < end; j++) {
                    List jump = miro.get(j);
                    
                    if(val != 0 && !ch.contains(jump)) {
                        ch.add(jump);
                        queue.offer(jump);
                    }
                }
                
            }
            L++;
        }

        L = -1;
    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    // 미로의 크기

        miro = new ArrayList<>();

        for (int i=0; i < n; i++) {
            miro.add(new ArrayList<>());
        }

        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i < n; i++) {
            miro.get(i).add(i);
            miro.get(i).add(Integer.parseInt(st.nextToken()));
        }
        
        bfs();

        System.out.print(L);
    }
}
