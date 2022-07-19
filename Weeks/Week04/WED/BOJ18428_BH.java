import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18428_BH {
    static int n;
    static String[][] map;
    static String[][] copy;
    static int count = 0;
    static Queue<Node> queue = new LinkedList<>();
    static int find = 0;
    static String answer = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        copy = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        obstacle(0);
        if (answer.equals("")) {
            System.out.println("NO");
        } else {
            System.out.println(answer);
        }
    }

    public static void obstacle(int count) {
        if (count == 3) {
            search();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    obstacle(count + 1);
                    map[i][j] = "X";
                }
            }
        }
    }

    public static void search() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j].equals("T")) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.row;
            int y = node.col;
            // 왼쪽 탐색
            for (int i = y - 1; i >= 0; i--) {
                if (copy[x][i].equals("X")) {
                    continue;
                } else if (copy[x][i].equals("O")) {
                    break;
                } else if (copy[x][i].equals("S")) {
                    find++;
                    break;
                } else if (copy[x][i].equals("T")) {
                    break;
                }
            }

            // 오른쪽 탐색
            for (int i = y + 1; i < n; i++) {
                if (copy[x][i].equals("X")) {
                    continue;
                } else if (copy[x][i].equals("O")) {
                    break;
                } else if (copy[x][i].equals("S")) {
                    find++;
                    break;
                } else if (copy[x][i].equals("T")) {
                    break;
                }
            }

            // 위 탐색
            for (int i = x - 1; i >= 0; i--) {
                if (copy[i][y].equals("X")) {
                    continue;
                } else if (copy[i][y].equals("O")) {
                    break;
                } else if (copy[i][y].equals("S")) {
                    find++;
                    break;
                } else if (copy[i][y].equals("T")) {
                    break;
                }
            }

            // 아래 탐색
            for (int i = x + 1; i < n; i++) {
                if (copy[i][y].equals("X")) {
                    continue;
                } else if (copy[i][y].equals("O")) {
                    break;
                } else if (copy[i][y].equals("S")) {
                    find++;
                    break;
                } else if (copy[i][y].equals("T")) {
                    break;
                }
            }
        }
        if (find == 0) {
            answer = "YES";
            return;
        } else {
            find = 0;
        }
    }

    public static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
