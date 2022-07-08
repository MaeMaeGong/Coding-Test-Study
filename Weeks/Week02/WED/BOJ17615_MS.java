import java.util.*;
import java.io.*;

public class BOJ17615_MS {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        list = new ArrayList<>();

        for (int i=0; i < N; i++) {
            char ch = str.charAt(i);

            if (i == 0) {
                list.add(new ArrayList<>());
                list.get(i).add(ch);
            }
            else {
                if (str.charAt(i-1) != ch) {
                    list.add(new ArrayList<>());
                    list.get(list.size()-1).add(ch);
                }
                else {
                    list.get(list.size()-1).add(ch);
                }
            }
        }


        // for (int i = 0; i < list.size(); i++) {
        //     for (int j = 0; j < list.get(i).size(); j++) {
        //         System.out.print(list.get(i).get(j) + " ");
        //     } 
        //     System.out.println();
        // }

        int count = 0;
        int answer = 0;

        if (list.size() > 1) {
            
            char ch = list.get(0).get(0);

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).get(0) == ch) {
                    count += list.get(i).size();
                }
            }

            answer = count;
            count = 0;

            ch = list.get(list.size()-1).get(0);

            for (int i = list.size()-2; i >= 0; i--) {
                if (list.get(i).get(0) == ch) {
                    count += list.get(i).size();
                }
            }

            if (count < answer) {
                answer = count;
            }

            if (list.get(list.size()-1).get(0) == list.get(list.size()-1).get(0)) {
                count = 0; 

                ch = str.charAt(0);

                for (int i = 1; i < list.size()-1; i++) {
                    if(list.get(i).get(0) != ch) {
                        count += list.get(i).size();
                    }
                }
            }

            if (count < answer) {
                answer = count;
            }
        }

        System.out.println(answer);
    }
}
