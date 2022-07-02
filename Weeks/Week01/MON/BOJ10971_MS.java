import java.util.*;
import java.io.*;;

public class BOJ10971_MS {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static int[] ch;

    public static void dfs (int start, int now, int count, int cost) {
        if (count == n-1) {
            if (board[now][start] != 0) {
                cost+= board[now][start];
                min = Math.min(min, cost);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (board[now][i] != 0 && ch[i] == 0) {
                ch[i] = 1; 
                dfs(start, i, count+1, cost + board[now][i]);
                ch[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    //  도시의 수

        board = new int[n][n];

        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());  
            for(int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
            }
        }

        for(int i=0; i<n; i++) {
            ch = new int[n];
            ch[i] = 1;
            dfs(i, i,0, 0);
        }
        
        System.out.println(min);
    }    
}
