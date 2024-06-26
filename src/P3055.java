import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int r, c;
    static char[][] board;
    static int[][] distWater;
    static int[][] dist;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        dist = new int[r][c];
        distWater = new int[r][c];

        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') {
                    q1.add(new Pair(i, j));
                    dist[i][j] = 1;
                }
                if (board[i][j] == '*') {
                    q2.add(new Pair(i, j));
                    distWater[i][j] = 1;
                }
                if (board[i][j] == 'D') {
                    x = i;
                    y = j;
                }
            }
        }

        while (!q2.isEmpty()) {
            Pair p = q2.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == 'X') continue;
                if (board[nx][ny] == 'D') continue;
                if (distWater[nx][ny] > 0) continue;
                q2.add(new Pair(nx, ny));
                distWater[nx][ny] = distWater[p.x][p.y] + 1;
            }
        }

        while (!q1.isEmpty()) {
            Pair p = q1.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == 'X') continue;
                if (dist[nx][ny] > 0) continue;
                if (distWater[nx][ny] > 0 && distWater[nx][ny] <= dist[p.x][p.y] + 1) continue;
                q1.add(new Pair(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
        if (dist[x][y] > 0) {
            bw.write(String.valueOf(dist[x][y] - 1));
        } else {
            bw.write("KAKTUS");
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
