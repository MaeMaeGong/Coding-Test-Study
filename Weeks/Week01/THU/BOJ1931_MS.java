import java.util.*;
import java.io.*;

class Time implements Comparable<Time> {
    public int start, end;
    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time o) {
        if (this.end == o.end )return this.start - o.start;
        else return this.end - o.end;
    }

}
public class BOJ1931_MS {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());   // 회의의 수

        StringTokenizer st;

        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }
        
        Collections.sort(list);
		
		int count = 0;

		int end = 0;
		for(Time ob : list) {
			System.out.println(ob.start + " " + ob.end);
									
			// 다음으로 오는 배열의 시작시간과 끝시간이 같거나 크다면 회의실 count를 증가시키고 끝나는 시간 저장
			if(end <= ob.start ) {
				count++;
				end = ob.end;
			}
		}

        System.out.println(count);
    }
}
