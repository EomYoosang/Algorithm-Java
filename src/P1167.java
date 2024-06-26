import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1167 {
    private static int V;
    private static List<List<Node>> graph;
    private static boolean[] vis;
    private static int farthestNode;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        vis = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                graph.get(v).add(new Node(u, dist));
                graph.get(u).add(new Node(v, dist));
            }
        }
        ans = 0;
        dfs(1,0);

        vis = new boolean[V+1];
        dfs(farthestNode,0);

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int v, int distance) {
        vis[v] = true;
        if(distance > ans) {
            ans = distance;
            farthestNode = v;
        }

        List<Node> list = graph.get(v);
        for (Node e : list) {
            if(vis[e.v]) continue;
            dfs(e.v, distance + e.dist);
        }
    }

    static class Node {
        int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}
