import java.util.*;
import java.io.*;

public class BOJ2504_MS {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int val = 1;
        int answer = 0;

        for (int i=0; i < str.length(); i++) {

            char x = str.charAt(i);

            if (x == '(') {
                stack.push(x);
                val *= 2;
            }

            if (x == '[') {
                stack.push(x);
                val *= 3;
            }

            if (x == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                
                if (str.charAt(i-1) == '(') { 
                    answer += val;
                }
                stack.pop();
                val/=2;
            }

            if (x == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                
                if (str.charAt(i-1) == '[') { 
                    answer += val;
                }
                stack.pop();
                val/=3;
            }

        }

        System.out.println(answer);
    }
}
