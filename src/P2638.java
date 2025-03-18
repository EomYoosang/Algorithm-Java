import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2638 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;
    static int n, m;
    static int[][] board;
    static boolean[][] vis;
    static Queue<Pair> q = new LinkedList<>();
    static boolean flag = true;
    static int air;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            solve();
            if (!flag) break;
            ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();

        br.close();
        bw.close();
    }

    public static void solve() {
        flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

        q.add(new Pair(0, 0));
        board[0][0] = 2;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            vis[p.x][p.y] = true;
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1 || board[nx][ny] == 2) continue;
                if (vis[nx][ny]) continue;
                board[nx][ny] = 2;
                q.add(new Pair(nx, ny));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                if (board[i][j] == 2) continue;
                flag = true;
                air = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (vis[nx][ny]) air++;
                }
                if (air >= 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
