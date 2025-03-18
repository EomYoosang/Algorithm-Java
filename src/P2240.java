import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2240 {
    static int t, w;
    static int[] tree;
    static int[][][] dp; // d[i][j][k]: i:현재시간, j:이동횟수, k:나무번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        tree = new int[t+1];
        dp = new int[t+1][w+1][3];

        for(int i=1;i<=t;i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0][1] = 0;

        for (int i = 1; i <= t; i++) {
            // 이동하지 않는 경우 (2번 나무는 이동안하면 못감)
            dp[i][0][1] = dp[i - 1][0][1] + (tree[i] == 1 ? 1 : 0);
            for (int j = 1; j <= w; j++) { // j번 이동
                if (i < j) break; // 현재 시간보다 많이 이동할 수 없다
                if (tree[i] == 1) { // 1번 나무인 경우
                    // 2번에 있다가 이동한 경우 vs 1번에 계속 있던 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
                else { // 2번 나무인 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }

        int ans = 0;

        for(int i=0;i<=w;i++){
            ans = Math.max(ans, dp[t][i][1]);
            ans = Math.max(ans, dp[t][i][2]);
        }

        System.out.println(ans);

        br.close();

    }
}
