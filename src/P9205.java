import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205 {
    static int t;
    static int n;
    static boolean[] vis;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean flag = false;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // home좌표
            Node home = new Node(x, y);

            // 편의점 좌표
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y);
            }

            // 페스티벌 좌표
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Node festival = new Node(x, y);

            vis = new boolean[n];
            q = new LinkedList<>();
            q.add(home);
            while (!q.isEmpty()) {
                Node current = q.poll();
                if (current.distance(festival) <= 1000) {
                    flag = true;
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if(current.distance(nodes[i]) > 1000) continue;
                    if(vis[i]) continue;
                    q.add(nodes[i]);
                    vis[i] = true;
                }
            }

            if (flag) bw.write("happy\n");
            else bw.write("sad\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Node o) {
            return Math.abs(o.x - this.x) + Math.abs(o.y - this.y);
        }
    }
}
