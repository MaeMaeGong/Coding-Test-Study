import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1092_BH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        int answer = 0;
        int idx = 0;
        if (crane.get(0) < box.get(0)) {
            System.out.println("-1");
        } else {
            while (!box.isEmpty()) {
                idx = 0;
                for (int i = 0; i < crane.size();) {
                    if (idx == box.size())// 박스가 비었으면 break 한다.
                        break;
                    else if (crane.get(i) >= box.get(idx)) { // 크레인 무게가 박스보다 무거우면 해당 박스 인덱스값 제거
                        box.remove(idx);
                        i++; // 다음 크레인으로 이동
                    } else
                        idx++;// 크레인으로 제거하지 못했을 때 옮길 수 있는 박스를 찾기 위해 idx값을 증가시킨다.
                }
                // 반복문을 종료했을 때 박스가 비어있지 않으면 1번 크레인부터 반복한다.
                answer++;
            }
            System.out.println(answer);
        }
    }
}
