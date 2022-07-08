import java.util.*;
import java.io.*;

public class BOJ10799_MS {
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stack.push(ch);
            }
            else {
                stack.pop();
                
                if (str.charAt(i-1) == '(') {
                    count += stack.size();
                }
                else {
                    count++;
                }
                
            }
        }

        System.out.println(count);
    }
}
