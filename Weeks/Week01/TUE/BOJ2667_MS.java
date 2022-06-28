import java.util.*;
import java.io.*;

public class BOJ2667_MS {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] box;
    static ArrayList<Integer> list = new ArrayList<>();
    static int n; 
    static int total = 0;
    static int count = 1;

    public static void dfs(int x, int y, int[][] box) {

        box[x][y] = 0;

        for (int i=0; i < 4; i++) {
            int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && box[nx][ny] == 1) {
                count++;
				box[nx][ny] = 0;
				dfs(nx, ny, box);
			}
            
        }
    }

    public static void Total(int[][] box) {

        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if(box[i][j] == 1) {
                    total++;
                    dfs(i , j, box);
                    list.add(count);
                    count = 1;
                }
            }   
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());    // 지도의 크기

        box = new int[n][n];

        for (int i=0; i < n; i++) {
            String token[] = br.readLine().split("");            
            for (int j=0; j < n; j++) {
                box[i][j] = Integer.parseInt(token[j]);
            } 
        }
        
        Total(box);

        System.out.println(total);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}