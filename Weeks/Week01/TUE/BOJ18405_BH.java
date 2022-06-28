
//문제링크 : https://www.acmicpc.net/problem/18405
//Virus 클래스에 x,y 좌표와 가중치 값 3가지를 선언하여 큐와 리스트에서 사용한다.
//compareTo 메소드를 사용하여 바이러스의 숫자가 작은값이 먼저 퍼질 수 있도록 선언해야한다.(공식처럼 사용)
//map에 0이 아닌값의 x,y좌표와 num값을 먼저 queue에 넣어준 후 bfs 탐색을 시작하는 것이 포인트 이다.
//bfs 탐색중 인접한 좌표의 값이 0일때 자신의 num값으로 바꿔주면서 탐색을 해야한다.
//바이러스의 종류가 3가지인 경우 3개의 바이러스가 모두 상,하,좌,우 이동을 하였을때 1초가 지난것임으로 bfs내부에서 그것을 판단해줄 로직이 필요하다.(98 ~ 106번 줄 확인)
//circle의 횟수가 S초만큼 진행하였을 때 bfs를 탈출하고 출력한다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18405_BH {

    static Queue<Virus> queue = new LinkedList<>();
    static ArrayList<Virus> list = new ArrayList<>();
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int[][] map;
    static boolean[][] visited;

    static int N, K, S, X, Y;

    static int time = 0;
    static int virus_cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                if (map[a][b] != 0) {
                    list.add(new Virus(a, b, map[a][b]));
                    virus_cnt++;
                }
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }

        bfs();

        if (map[X - 1][Y - 1] == 0) {
            System.out.println("0");
        } else {
            System.out.println(map[X - 1][Y - 1]);
        }
    }

    public static void bfs() {

        int circle = 0;

        while (!queue.isEmpty()) {
            Virus vi = queue.poll();
            int r = vi.x;
            int c = vi.y;
            int v_num = vi.num;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (map[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        map[nr][nc] = v_num;
                        queue.add(new Virus(nr, nc, v_num));
                    }
                }
            }

            time++;

            if (time == virus_cnt) {
                circle++;
            }

            if (circle == S) {
                break;
            }
        }

    }

    static class Virus implements Comparable<Virus> {
        int x, y, num;

        public Virus(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Virus other) {
            if (this.num < other.num) {
                return -1;
            }
            return 1;
        }
    }
}
