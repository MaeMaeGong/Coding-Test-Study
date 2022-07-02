import java.util.*;
import java.io.*;

public class BOJ4963_MS {

    static int w, h;
    static int[][] map;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void dfs(int x, int y, int[][] map) {

        map[x][y] = 0;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                dfs(nx, ny, map);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());   // 지도의 너비
            h = Integer.parseInt(st.nextToken());   // 지도의 높이

            if (w == 0 && h == 0) break;
            
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j, map);
                        count++;
                    }
                }
            }

            list.add(count);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }   
}
