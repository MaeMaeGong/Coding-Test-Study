import java.util.*;
import java.io.*;

public class BOJ18115_MS {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));   
        }

        Collections.reverse(arr);

        for (int i=0; i < N; i++) {

            if (arr.get(i) == 1) {
                deque.addFirst(i+1);
            }
            else if (arr.get(i) == 2) {

                if (deque.size() == 0) {
                    deque.add(i+1);
                }
                else {
                    int temp = deque.pollFirst();
                    deque.addFirst(i+1);
                    deque.addFirst(temp);
                }
            } 
            else if (arr.get(i) == 3) {
                deque.add(i+1);
            } 
        }

        for (int i : deque) {
            bw.write(i + " ");
        }
        bw.flush();
		bw.close(); 
    }
}
