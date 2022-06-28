
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644_MS {
    
    static int[][] node;
	static int[] ch;
	static int n, m, p2, answer;
    static int count = 0;

    public static void dfs(int v, int count) {
		ch[v] = 1;
        
        if (v == p2) {
            answer = count;
            return;
        }
        else {
            for (int i=1; i < n+1; i++) {
                if(node[v][i] == 1 && ch[i] == 0) {  
                    ch[i] = 1;
                    dfs(i, count+1);              
                }
                    
            }
        }

	}

    public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());       // 정점의 개수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());  
        p2 = Integer.parseInt(st.nextToken());  // 촌수 계산해야하는 두 사람 번호

		m = Integer.parseInt(br.readLine());	    // 관계 개수
		
		node = new int[n+1][n+1];
        ch = new int[n+1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = node[y][x] = 1;
		}

		dfs(p1, 0);
        
        if (answer != 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
	}
}
