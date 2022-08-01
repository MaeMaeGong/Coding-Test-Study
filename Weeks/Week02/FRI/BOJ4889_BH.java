import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4889_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();

        int answer = 0;
        int cnt = 0;
        while (true) {
            cnt++;
            String input = br.readLine();
            if (input.substring(0, 1).equals("-")) {
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                String temp = input.substring(i, i + 1);
                if (i == 0) {
                    if (temp.equals("}")) {
                        temp = "{";
                        stack.add(temp);
                        answer++;
                    } else {
                        stack.add(temp);
                    }
                } else {
                    if (stack.isEmpty()) {
                        if (temp.equals("{")) {
                            stack.add(temp);
                        } else {
                            temp = "{";
                            stack.add(temp);
                            answer++;
                        }
                    } else {
                        if (temp.equals("{")) {
                            stack.add(temp);
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
            answer += stack.size() / 2;// 그리디
            bw.write(cnt + ". " + answer + "\n");
            answer = 0;
            stack.clear();
        }
        bw.flush();
        bw.close();
    }
}
