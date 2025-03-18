import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    static int n, m;
    static int[] vtx;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vtx = new int[101];
        dist = new int[101];
        for (int i = 1; i <= 100; i++) {
            vtx[i] = i;
            dist[i] = -1;
        }
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vtx[a] = b;
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                break;
            }
            for (int i = 1; i <= 6; i++) {
                if (cur + i > 100) continue;
                if (dist[vtx[cur + i]] > -1) continue;
                dist[vtx[cur + i]] = dist[cur] + 1;
                q.offer(vtx[cur + i]);
            }
        }

        System.out.println(dist[100]);

        br.close();

    }
}
