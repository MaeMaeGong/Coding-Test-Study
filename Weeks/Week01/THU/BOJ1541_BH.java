import java.io.BufferedReader;
import java.io.InputStreamReader;

//괄호를 적절히 쳐서 입력값의 합을 최소로 만들어라.
//
public class BOJ1541_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int sum2 = 0;
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("+")) {
                String[] sum1 = input[i].split("\\+");
                for (int j = 0; j < sum1.length; j++) {
                    sum2 += Integer.parseInt(sum1[j]);
                }
            } else {
                sum2 = Integer.parseInt(input[i]);
            }

            if (i == 0) {
                answer += sum2;
                sum2 = 0;
            } else {
                answer -= sum2;
                sum2 = 0;
            }

        }
        System.out.println(answer);
    }
}
