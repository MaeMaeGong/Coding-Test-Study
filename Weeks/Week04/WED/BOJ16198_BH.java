import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16198_BH {
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Backtracking(list, 0);
        System.out.println(answer);
    }

    public static void Backtracking(ArrayList<Integer> list, int sum) {
        if (list.size() == 2) {
            answer = Math.max(answer, sum);
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int num = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            // for (int s : list) {
            // System.out.print(s + " ");
            // }
            // System.out.println();
            Backtracking(list, sum + num);
            list.add(i, temp);
        }
    }
}
