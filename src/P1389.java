import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1389 {
    static int n, m;
    static boolean[][] vtx;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vtx = new boolean[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vtx[a][b] = vtx[b][a] = true;
        }

        for (int i = 1; i <= n; i++) {
            Queue<Node> q = new LinkedList<>();
            for (int j = 1; j <= n; j++) {
                // 관계 없으면 continue;
                if (i == j) continue;
                if (!vtx[i][j]) continue;
                q.offer(new Node(j, 1));
                dist[i][j] = 1;
            }
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int j = 1; j <= n; j++) {
                    // 관계 없으면 continue;
                    if (i == j) continue;
                    if (!vtx[cur.friend][j]) continue;
                    // 이미 연결되었으면 continue;
                    if (dist[i][j] > 0) continue;
                    q.offer(new Node(j, cur.dist + 1));
                    dist[i][j] = cur.dist + 1;
                }
            }
        }

        int ans = 1;
        int min = 25000000;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                sum += dist[i][j];
            }
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Node {
        int friend;
        int dist;

        public Node(int friend, int dist) {
            this.friend = friend;
            this.dist = dist;
        }
    }
}
