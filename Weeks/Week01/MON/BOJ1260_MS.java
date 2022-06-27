// dfs : 시작 번호를 지정한 후 간선 파악과 방문여부를 확인 한 후 조건에 맞으면 dfs를 재호출 하여 탐색
// bfs : 큐를 사용하여 시작 번호를 offer 한 후 간선 파악과 방문여부를 확인 한 후 연결된 모든 노드를 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ1260_MS {  
	
	static int[][] node;
	static int[] ch;
	static int n, m, v;

	public static void dfs (int v) {
		ch[v] = 1;
		System.out.print(v + " ");
		for (int i=1; i <= n; i++) {
			if(node[v][i] == 1 && ch[i] == 0) {
				dfs(i);
			}
		}

	}

	public static void bfs () {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(v);

		ch[v] = 1;
		System.out.print(v + " ");

		while (!Q.isEmpty()) {
			int temp = Q.poll();

			for (int i=1; i <= n; i++) {
				if(node[temp][i] == 1 && ch[i] == 0) {
					Q.offer(i);
					ch[i] = 1;
					System.out.print(i + " ");
				}
			}
		}	

	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());    // 정점 개수
		m = Integer.parseInt(st.nextToken());	 // 간선 개수
		v = Integer.parseInt(st.nextToken());	 // 시작 번호
		
		node = new int[n+1][n+1];
        ch = new int[n+1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = node[y][x] = 1;
		}

		dfs(v);
		ch = new int[n+1];		// ch 초기화
		System.out.println();
		bfs();

	}
}
