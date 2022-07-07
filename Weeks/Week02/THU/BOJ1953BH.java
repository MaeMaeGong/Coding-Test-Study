import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ1953BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        Stack<Double> stack = new Stack<>();
        Double[] word_num = new Double[N];

        for (int i = 0; i < N; i++) {
            word_num[i] = Double.parseDouble(br.readLine());
        }
        for (int i = 0; i < word.length() - 1; i++) {
            String temp = word.substring(i, i + 1);
            if (!temp.equals("+") && !temp.equals("-") && !temp.equals("/") && !temp.equals("*")) {
                if (!list.contains(temp)) {
                    list.add(temp);
                }
            }
        }

        // for (Double s : word_num) {
        // System.out.print(s + " ");
        // }
        // System.out.println();
        // for (String s : list) {
        // System.out.print(s + " ");
        // }
        // System.out.println();
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(i, i + 1);
            if (!temp.equals("+") && !temp.equals("-") && !temp.equals("/") && !temp.equals("*")) {
                stack.add(word_num[list.indexOf(temp)]);
            } else if (temp.equals("+")) {
                double x = stack.pop();
                double y = stack.pop();
                stack.add(x + y);
            } else if (temp.equals("-")) {
                double x = stack.pop();
                double y = stack.pop();
                stack.add(y - x);
            } else if (temp.equals("*")) {
                double x = stack.pop();
                double y = stack.pop();
                stack.add(x * y);
            } else if (temp.equals("/")) {
                double x = stack.pop();
                double y = stack.pop();
                stack.add(y / x);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
