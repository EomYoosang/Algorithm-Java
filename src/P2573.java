import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {

    static int n, m;
    static int[][] board;
    static boolean[][] meltVis;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int depth = 0;

        while (true) {
            vis = new boolean[n][m];
            int cnt = 0;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (board[i][j] == 0) continue;
                    if (vis[i][j]) continue;
                    dfs(i, j);
                    cnt++;
                }
            }
            if (cnt > 1) {
                bw.write(String.valueOf(depth));
                break;
            }
            if (cnt == 0) {
                bw.write("0");
                break;
            }
            melt();
            depth++;
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void melt() {
        meltVis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int curX = i + dx[d];
                    int curY = j + dy[d];
                    if (curX < 0 || curX > n - 1 || curY < 0 || curY > m - 1) continue;
                    if (board[curX][curY] != 0) continue;
                    if (meltVis[curX][curY]) continue;
                    cnt++;
                }
                board[i][j] = board[i][j] - cnt > 0 ? board[i][j] - cnt : 0;
                if (board[i][j] == 0) {
                    meltVis[i][j] = true;
                }
            }
        }
    }

    public static void dfs(int x, int y) {
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX <= 0 || curX >= n - 1 || curY <= 0 || curY >= m - 1) continue;
            if (board[curX][curY] == 0) continue;
            if (vis[curX][curY]) continue;
            dfs(curX, curY);
        }
    }
}
