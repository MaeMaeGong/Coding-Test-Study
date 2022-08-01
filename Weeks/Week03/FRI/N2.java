// import java.util.LinkedList;
// import java.util.Queue;

// public class N2 {

// static int n, k;
// static int answer = 0;

// public static void main(String[] args) {
// n = 10;
// k = 2;

// bfs();
// System.out.println(answer);
// }

// public static void bfs() {

// Queue<Rabbit> queue = new LinkedList<Rabbit>();

// for (int i = n - 1; i >= n / 2; i--) {
// queue.add(new Rabbit(i, i, 1));
// }

// while (!queue.isEmpty()) {
// Rabbit rab = queue.poll();
// if (rab.count == k) {
// if (rab.sum == n) {
// answer++;
// }
// } else {
// for (int i = rab.now - 1; i >= 1; i--) {
// queue.add(new Rabbit(i, rab.sum + i, rab.count + 1));
// }
// }

// }
// }

// static class Rabbit {
// int now, sum, count;

// public Rabbit(int now, int sum, int count) {
// this.now = now;
// this.sum = sum;
// this.count = count;
// }
// }
// }