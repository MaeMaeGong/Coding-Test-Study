import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16509_BH {
    static int[] dr = { -3, -3, -2, 2, 3, 3, 2, -2 };
    static int[] dc = { -2, 2, 3, 3, 2, -2, -3, -3 };

    static int start_x, start_y, target_x, target_y;

    static int[][] map;
    static boolean[][] visited;

    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[10][9];
        visited = new boolean[10][9];
        start_x = Integer.parseInt(st.nextToken());
        start_y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        target_x = Integer.parseInt(st.nextToken());
        target_y = Integer.parseInt(st.nextToken());

        bfs(start_x, start_y);
    }

    public static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, count));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == target_x && node.y == target_y) {
                System.out.println(node.cnt);
            }

            for (int i = 0; i < 8; i++) {
                int nr = node.x + dr[i];
                int nc = node.y + dc[i];
                if (nr >= 0 && nc >= 0 && nr < 10 && nc < 9) {
                    // System.out.println(nr + " " + nc);
                    if (checkFunc(i, nr, nc) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new Node(nr, nc, node.cnt + 1));
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static boolean checkFunc(int index, int x, int y) {
        // System.out.println(index + " " + x + " " + y);
        if (index == 0 || index == 7) {
            for (int i = 1; i <= 2; i++) {
                if (x + i == target_x && y + i == target_y)
                    return false;
            }
        }
        if (index == 1 || index == 2) {
            for (int i = 1; i <= 2; i++) {
                if (x + i == target_x && y - i == target_y)
                    return false;
            }
        }
        if (index == 3 || index == 4) {
            for (int i = 1; i <= 2; i++) {
                if (x - i == target_x && y - i == target_y)
                    return false;
            }
        }
        if (index == 5 || index == 6) {
            for (int i = 1; i <= 2; i++) {
                if (x - i == target_x && y + i == target_y)
                    return false;
            }
        }
        return true;
    }
}
