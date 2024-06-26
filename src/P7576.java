import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int m, n;
    static int[][] board;
    static int[][] dist;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 1;
                }
                if (board[i][j] == -1) {
                    dist[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                if (dist[curX][curY] != 0) continue;
                if (board[curX][curY] != 0) continue;
                q.add(new Pair(curX, curY));
                dist[curX][curY] = dist[p.x][p.y] + 1;
                ans = ans > dist[curX][curY]-1 ? ans : dist[curX][curY]-1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == 0) {
                    ans = -1;
                    break;
                }
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
