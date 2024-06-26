import java.io.*;
import java.util.StringTokenizer;

public class P1987 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int r;
    static int c;
    static char[][] board;
    static boolean[] alp = new boolean[26];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int result = dfs(0, 0, 1);
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dfs(int x, int y, int count) {
        int max = count;
        if (alp[board[x][y] - 'A']) {
            return count;
        } else {
            alp[board[x][y] - 'A'] = true;
            for (int d = 0; d < 4; d++) {
                int curX = x + dx[d];
                int curY = y + dy[d];
                if (curX < 0 || curX >= r | curY < 0 || curY >= c) continue;
                if (alp[board[curX][curY] - 'A']) continue;
                max = Math.max(max, dfs(curX, curY, count + 1));
            }
            alp[board[x][y] - 'A'] = false;
        }
        return max;
    }

    private static class Pair {
        int x, y;

        Pair() {

        }

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }
}
