import java.io.*;
import java.util.Stack;

public class P10026 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());

        char[][] board1 = new char[n][n];
        char[][] board2 = new char[n][n];
        boolean[][] vis1 = new boolean[n][n];
        boolean[][] vis2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board2[i][j] = board1[i][j] = line.charAt(j);
                if (board2[i][j] == 'G') {
                    board2[i][j] = 'R';
                }
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis1[i][j]) {
                    Stack<Pair> s1 = new Stack<>();
                    s1.push(new Pair(i, j));
                    vis1[i][j] = true;
                    cnt1++;
                    while (!s1.empty()) {
                        Pair p = s1.pop();
                        for (int d = 0; d < 4; d++) {
                            int curX = p.x + dx[d];
                            int curY = p.y + dy[d];
                            if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue;
                            if (vis1[curX][curY]) continue;
                            if (board1[curX][curY] != board1[p.x][p.y]) continue;
                            s1.push(new Pair(curX, curY));
                            vis1[curX][curY] = true;
                        }
                    }
                }

                if (!vis2[i][j]) {
                    Stack<Pair> s2 = new Stack<>();
                    s2.push(new Pair(i, j));
                    vis2[i][j] = true;
                    cnt2++;
                    while (!s2.empty()) {
                        Pair p = s2.pop();
                        for (int d = 0; d < 4; d++) {
                            int curX = p.x + dx[d];
                            int curY = p.y + dy[d];
                            if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue;
                            if (vis2[curX][curY]) continue;
                            if (board2[curX][curY] != board2[p.x][p.y]) continue;
                            s2.push(new Pair(curX, curY));
                            vis2[curX][curY] = true;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt1) + ' ' + String.valueOf(cnt2));
        bw.flush();
        br.close();
        bw.close();
    }

    private static class Pair {
        int x, y;
        public Pair Pair;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
