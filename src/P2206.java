import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    static int n, m;
    static int[][] board;
    static boolean[][][] vis;
    static int[][] dist;
    static Queue<Node> q;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[2][n][m];
        dist = new int[n][m];

        q = new LinkedList();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        q.offer(new Node(0, 0, false));
        vis[0][0][0] = true;
        vis[1][0][0] = true;
        dist[0][0] = 1;
        // 출발지와 목적지가 같을 경우
        if (n == 1 && m == 1) {
            System.out.println("1");
            br.close();
            System.exit(0);
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(dist[n - 1][m - 1]);
                br.close();
                System.exit(0);
            }
            for (int d = 0; d < 4; d++) {
                // 다음 좌표 추적
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                // 범위 넘어가면 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽이 아닌 경우
                if (board[nx][ny] == 0) {
                    // 벽을 부순 적이 있는 경우
                    if (cur.destroyed && !vis[1][nx][ny]) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        vis[1][nx][ny] = true;
                        q.offer(new Node(nx, ny, true));
                    }
                    // 벽을 부순 적이 없는 경우
                    if (!cur.destroyed && !vis[0][nx][ny]) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        vis[0][nx][ny] = true;
                        q.offer(new Node(nx, ny, false));
                    }

                }
                // 벽인 경우 && 벽을 부순 적이 없는 경우
                if (board[nx][ny] == 1 && !cur.destroyed && !vis[1][nx][ny]) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    vis[1][nx][ny] = true;
                    q.offer(new Node(nx, ny, true));
                }
            }
        }

        System.out.println("-1");

        br.close();
    }

    static class Node {
        int x, y;
        boolean destroyed;

        public Node(int x, int y, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
        }
    }
}
