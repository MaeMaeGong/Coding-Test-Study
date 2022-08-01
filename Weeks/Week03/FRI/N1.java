// import java.util.*;

// class Solution {
// public int solution(int[][] p) {
// int[][] arr = new int[1001][1001];
// int answer = 0;
// for (int i = 0; i < p.length; i++) {
// int x = p[i][0];
// int y = p[i][1];
// arr[x][y] = 1;
// }

// for (int i = 1; i < 1001; i++) {
// for (int j = 1; j < 1001; j++) {
// if (arr[i][j] == 1) {
// if (arr[j][i] == 1) {
// answer++;
// arr[i][j] = 0;
// arr[j][i] = 0;
// }
// }
// }
// }

// return answer;
// }
// }