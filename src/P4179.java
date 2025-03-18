import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] board;
    static int ans = 1000000;
    static int[][] dist1;
    static int[][] dist2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());

        Queue<Pair> fireQ = new LinkedList<>();
        Queue<Pair> q = new LinkedList<>();
        dist1 = new int[r][c];
        dist2 = new int[r][c];
        board = new char[r][c];

        // board 입력
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                dist1[i][j] = -1;
                dist2[i][j] = -1;
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'J') {
                    q.add(new Pair(i, j));
                    dist2[i][j] = 0;
                }
                if (board[i][j] == 'F') {
                    fireQ.add(new Pair(i, j));
                    dist1[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            Pair p = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '#' || dist1[nx][ny] >= 0) continue;
                dist1[nx][ny] = dist1[p.x][p.y] + 1;
                fireQ.add(new Pair(nx, ny));
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    ans = Math.min(ans, dist2[p.x][p.y] + 1);
                    continue;
                }
                if (board[nx][ny] == '#' || dist2[nx][ny] >= 0) continue;
                if (dist2[p.x][p.y] + 1 >= dist1[nx][ny] && dist1[nx][ny] >= 0) continue;
                dist2[nx][ny] = dist2[p.x][p.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        if (ans < 1000000) {
            bw.write(String.valueOf(ans) + '\n');
        } else {
            bw.write("IMPOSSIBLE\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
