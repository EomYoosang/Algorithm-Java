import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {
    static int n;
    static int[] w;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = dp[0][1] = 0;
        dp[1][0] = w[1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i - 1][0] + w[i];
            for (int j = 0; j < i - 1; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[j][0] + w[i]);
                dp[i][0] = Math.max(dp[i][0], dp[j][1] + w[i]);
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        System.out.println(ans);

        br.close();
    }
}
