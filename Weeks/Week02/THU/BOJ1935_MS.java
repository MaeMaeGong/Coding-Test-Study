import java.util.*;
import java.io.*;

public class BOJ1935_MS {
    

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        ArrayList<Integer> arr = new ArrayList<>();

        Stack<Double> stack = new Stack<>();

        Map<Character, Double> map = new HashMap<>();

        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                if (!map.containsKey(ch)) map.put(ch, Double.parseDouble(br.readLine()));
            }
        }

        int min = Math.min(2, 5);
        

        double val = 0.0;
        for (int i=0; i < str.length(); i++) {
            
            char ch = str.charAt(i);

            if(ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                stack.push(map.get(ch));
            }
            else {
                double s1 = stack.pop();
                double s2 = stack.pop();

                if (ch == '+') {
                    val = s1 + s2;
                }
                else if (ch == '-') {
                    val = s2 - s1;
                }
                else if (ch == '*') {
                    val = s1 * s2;
                } 
                else if (ch == '/') {
                    val = s2 / s1;
                }
                stack.push(val);
            }              
        }

        System.out.printf("%.02f", val);
    }
}
