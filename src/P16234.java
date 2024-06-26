import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16234 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, l, r;
    static int[][] board;
    static boolean[][] vis;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        while (flag) {
            Queue<Pair> q;
            Queue<Pair> q2;
            vis = new boolean[n][n];
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j]) continue;
                    int total = 0;
                    int cnt = 1;
                    q = new LinkedList<>();
                    q2 = new LinkedList<>();
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        total += board[p.x][p.y];
                        q2.add(new Pair(p.x, p.y));
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (vis[nx][ny]) continue;
                            int sub = Math.abs(board[p.x][p.y] - board[nx][ny]);
                            if (sub < l || sub > r) continue;
                            q.add(new Pair(nx, ny));
                            flag = true;
                            vis[nx][ny] = true;
                            cnt++;
                        }
                    }
                    int sum = total / cnt;
                    while (!q2.isEmpty()) {
                        Pair p = q2.poll();
                        board[p.x][p.y] = sum;
                    }
                }
            }
            if(flag){
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
