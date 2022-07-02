
//1차원 bfs이지만 이동의 경우의수가 다양한 문제
//목표 위치로 가기위해서 경로의 인덱스값을 알고 있어야한다.
//ex) 10에서 20으로 이동할때 출발지에서 10까지 이동한 횟수가 3일때 10 -> 20이면 이동횟수가 1증가하여 4가된다.
//즉 출발지에서 목표지로 갈때까지 방문한 배열의 인덱스 값마다 1씩 더해주면서 이동한다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_BH {
    static int N, K;
    static boolean[] visited;
    static int count = 0;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        dist = new int[100001];
        bfs(N, K);
        System.out.println(dist[K]);
    }

    public static void bfs(int n, int k) {
        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (temp == k) {
                break;
            }

            if (temp * 2 < 100001 && !visited[temp * 2]) {
                visited[temp * 2] = true;
                queue.add(temp * 2);
                dist[temp * 2] = dist[temp] + 1;
            }
            if (temp + 1 < 100001 && !visited[temp + 1]) {
                visited[temp + 1] = true;
                queue.add(temp + 1);
                dist[temp + 1] = dist[temp] + 1;
            }
            if (temp - 1 >= 0 && !visited[temp - 1]) {
                visited[temp - 1] = true;
                queue.add(temp - 1);
                dist[temp - 1] = dist[temp] + 1;
            }
        }
    }
}
