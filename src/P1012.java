import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1012 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][m];
            boolean[][] vis = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[a][b] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vis[i][j]) continue;
                    if(board[i][j] == 0) continue;
                    Stack<Pair> s = new Stack<>();
                    s.push(new Pair(i, j));
                    vis[i][j] = true;
                    cnt++;
                    while (!s.empty()) {
                        Pair p = s.pop();
                        for (int d = 0; d < 4; d++) {
                            int curX = p.getX() + dx[d];
                            int curY = p.getY() + dy[d];
                            if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                            if (vis[curX][curY]) continue;
                            if(board[curX][curY] == 0) continue;
                            s.push(new Pair(curX, curY));
                            vis[curX][curY] = true;
                        }
                    }
                }
            }
            bw.write(String.valueOf(cnt) + '\n');
        }
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
