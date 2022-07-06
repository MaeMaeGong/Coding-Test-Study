import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String bracket = br.readLine();
        String[] check = new String[bracket.length()];
        int answer = 0;
        int m = 1;
        int cnt = 0;
        for (int i = 0; i < bracket.length(); i++) {
            String word = bracket.substring(i, i + 1);
            check[i] = word;
            if (word.equals("(")) {
                m *= 2;
                stack.push(word);
            } else if (word.equals("[")) {
                m *= 3;
                stack.push(word);
            } else if (word.equals(")")) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals("(")) {
                        if (check[i - 1].equals("("))
                            answer += m;
                        m /= 2;
                        stack.pop();
                    }
                } else {
                    cnt++;
                }
            } else if (word.equals("]")) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals("[")) {
                        if (check[i - 1].equals("["))
                            answer += m;
                        m /= 3;
                        stack.pop();
                    }
                } else {
                    cnt++;
                }
            }
        }
        if (!stack.isEmpty() || cnt > 0) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
