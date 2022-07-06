import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<String> deq = new LinkedList<>();
        int T = Integer.parseInt(st.nextToken());

        for (int test = 0; test < T; test++) {
            String p = br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start_n = n;
            String input_arr = br.readLine();
            String arr = input_arr.substring(1, input_arr.length() - 1);
            String[] new_arr = arr.split(",");

            for (int i = 0; i < new_arr.length; i++) {
                deq.addLast(new_arr[i]);
            }

            int R_count = 0;
            int D_count = 0;
            int cnt = 0;
            String[] c = new String[n];// 뒤집기용 빈 문자열 변수
            if (n > 0) {
                for (int i = 0; i < p.length(); i++) {
                    if (p.substring(i, i + 1).equals("R")) {
                        R_count++;
                    } else if (p.substring(i, i + 1).equals("D")) {
                        if (R_count % 2 == 0) {
                            if (!deq.isEmpty()) {
                                // 맨 앞 제거
                                deq.pollFirst();
                                // 배열 갯수 감소
                                n--;
                            } else {
                                cnt++;
                            }
                        } else {
                            if (!deq.isEmpty()) {
                                // 2. 제거
                                deq.pollLast();
                                n--;
                            } else {
                                cnt++;
                            }
                        }
                    }
                }

                if (R_count % 2 != 0) {
                    // 1. 뒤집기
                    for (int j = 0; j < n; j++) {
                        c[j] = deq.pollLast();
                    }

                    for (int k = 0; k < n; k++) {
                        deq.addLast(c[k]);
                    }
                }

                if (cnt == 0) {
                    bw.write("[");
                    for (int s = 0; s < n; s++) {
                        bw.write(deq.pollFirst() + "");
                        if (s != n - 1) {
                            bw.write(",");
                        }
                    }
                    bw.write("]");
                    bw.write("\n");
                } else if (D_count > start_n) {
                    bw.write("error" + "\n");
                } else {
                    bw.write("error" + "\n");
                }
                deq.clear();
            } else {
                if (p.contains("D")) {
                    bw.write("error" + "\n");
                } else {
                    bw.write("[]" + "\n");
                }
                deq.clear();
            }
        }
        bw.flush();
        bw.close();
    }
}