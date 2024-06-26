import java.io.*;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class P2667 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        boolean[][] vis = new boolean[n][n];
        int cnt = 0;
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 이미 방문했으면 패스
                if (vis[i][j]) continue;
                // 아파트가 없으면 패스
                if (arr[i][j] == 0) continue;
                cnt++;
                int size = 1;
                Stack<Pair> s = new Stack<>();
                s.push(new Pair(i, j));
                vis[i][j] = true;
                while (!s.empty()) {
                    Pair p = s.pop();
                    for (int k = 0; k < 4; k++) {
                        int curX = p.getX() + dx[k];
                        int curY = p.getY() + dy[k];
                        // 범위 벗어나면 패스
                        if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue;
                        // 이미 방문했거나 아파트 없으면 패스
                        if (vis[curX][curY] || arr[curX][curY] == 0) continue;
                        s.push(new Pair(curX, curY));
                        size++;
                        vis[curX][curY] = true;
                    }
                }
                v.add(size);
            }
        }
        bw.write(String.valueOf(cnt) + '\n');
        Collections.sort(v);
        for (int i = 0; i < v.size(); i++) {
            bw.write(String.valueOf(v.get(i)) + '\n');
        }
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


