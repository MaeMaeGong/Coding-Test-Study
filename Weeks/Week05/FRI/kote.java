import java.util.LinkedList;
import java.util.Queue;

public class kote {
    static int a, b;
    static int cnt = 0;
    static int count = 0;
    static int answer = 0;
    static Queue<Node> queue = new LinkedList<>();

    static String[][] map;

    public static void main(String[] args) {
        String[] drum = { "######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######" };
        a = drum.length;
        b = drum[0].length();
        map = new String[a][b];
        System.out.println(a + " " + b);
        for (int i = 0; i < a; i++) {
            String s = drum[i];
            for (int j = 0; j < b; j++) {
                map[i][j] = s.substring(j, j + 1);
            }
        }

        for (String[] s : map) {
            for (String ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < b; i++) {
            bfs(0, i);
            queue.clear();
            cnt = 0;
            count = 0;
        }

        System.out.println(answer);
    }

    public static void bfs(int r, int c) {
        queue.add(new Node(r, c));
        // System.out.println(r + " " + c);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // System.out.println(node.x + " " + node.y);
            // System.out.println(map[node.x][node.y]);
            if (map[node.x][node.y].equals("#")) {
                count++;
                int nr = node.x + 1;
                int nc = node.y;
                if (nr >= 0 && nc >= 0 && nr < a && nc < b) {
                    queue.add(new Node(nr, nc));
                }
            } else if (map[node.x][node.y].equals(">")) {
                int nr = node.x;
                int nc = node.y + 1;
                if (nr >= 0 && nc >= 0 && nr < a && nc < b) {
                    queue.add(new Node(nr, nc));
                }
            } else if (map[node.x][node.y].equals("<")) {
                int nr = node.x;
                int nc = node.y - 1;
                if (nr >= 0 && nc >= 0 && nr < a && nc < b) {
                    queue.add(new Node(nr, nc));
                }
            } else if (map[node.x][node.y].equals("*")) {
                cnt++;
                int nr = node.x + 1;
                int nc = node.y;
                if (cnt < 2 && nr >= 0 && nc >= 0 && nr < a && nc < b) {
                    count++;
                    queue.add(new Node(nr, nc));
                }
            }

            if (count == a) {
                answer += 1;
                return;
            }
        }

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
