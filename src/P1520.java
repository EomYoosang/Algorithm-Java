import java.io.*;
import java.util.StringTokenizer;

public class P1520 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int[][] dp;
    static int m;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int result = dfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX < 0 || curX >= m || curY < 0 || curY >= n) continue;
            if (board[x][y] <= board[curX][curY]) continue;
            dp[x][y] += dfs(curX, curY);
        }
        return dp[x][y];
    }
}
