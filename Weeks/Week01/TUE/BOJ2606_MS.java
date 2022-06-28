import java.util.*;
import java.io.*;

public class BOJ2606_MS {

    static int[][] node;
    static int[] ch;
    static int count = 0;
    static int n, m;

    public static void dfs(int nd) {
        ch[nd] = 1;
        
        for(int i = 1; i < n+1; i++) {
            if(node[nd][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                count++;
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    // 컴퓨터 수
        m = Integer.parseInt(br.readLine());    // 연결된 쌍의 수

        StringTokenizer st;
        
        node = new int[n+1][n+1];
        ch = new int[n+1];

        for (int i =0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            node[x][y] = node[y][x] = 1;
        }
        
        dfs(1);
        
        System.out.println(count);
    }
}