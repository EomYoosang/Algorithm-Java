import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
    static int n, k;
    static boolean[] vis;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        vis = new boolean[100001];

        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(n, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            vis[p.x] = true;
            if(p.x == k) {
                ans = p.time;
                break;
            }
            int nx;
            // 2*x
            nx = p.x * 2;
            if (nx >= 0 && nx <= 100000 && !vis[nx]) {
                q.add(new Pair(nx, p.time));
            }

            // x-1
            nx = p.x - 1;
            int nt = p.time + 1;
            // 범위 벗어남
            if (nx >= 0 && nx <= 100000 && !vis[nx]) {
                q.add(new Pair(nx, nt));
            }
            // x+1
            nx = p.x + 1;
            // 범위 벗어남
            if (nx >= 0 && nx <= 100000 && !vis[nx]) {
                q.add(new Pair(nx, nt));
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static class Pair implements Comparable<Pair> {
        int x, time;

        Pair(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.time > pair.time)
                return 1;
            else if (this.time < pair.time)
                return -1;
            return 0;
        }
    }

}
