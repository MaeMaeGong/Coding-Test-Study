import java.io.*;

public class BOJ1541_MS {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split("-");
        
        for(int i = 0; i < token.length; i++) {

            if(token[i].contains("+")) {                
                String[] temp = token[i].split("\\+");
                int sum = 0;
                for (int j = 0; j < temp.length; j++) {
                    sum += Integer.parseInt(temp[j]);
                }

                token[i] = Integer.toString(sum);
            }
        }

        int sum = Integer.parseInt(token[0]);


        for (int i = 1; i < token.length; i++) {
            sum -= Integer.parseInt(token[i]);
        }

        System.out.println(sum);
    }
}
