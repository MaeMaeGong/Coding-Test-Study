import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] bracket = new String[input.length()];
        Stack<String> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            bracket[i] = input.substring(i, i + 1);
        }

        // for (String s : bracket) {
        // System.out.print(s + " ");
        // }

        for (int i = 0; i < input.length(); i++) {
            if (bracket[i].equals("(")) {
                stack.add(bracket[i]);
            } else {
                if (!stack.isEmpty()) {
                    if (bracket[i - 1].equals("(")) {
                        stack.pop();
                        answer += stack.size();
                    } else {
                        answer += 1;
                        stack.pop();
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.println(answer);
    }
}