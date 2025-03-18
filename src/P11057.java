import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11057 {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10];
        // dp[n][i]는 n자리에 끝자리가 i인 오르막수의 개수

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                // dp[i][j] = dp[i-1][0] + ... + dp[i-1][j] = dp[i][j-1] + dp[i-1][j]
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%10007;
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= 10007;
        }

        System.out.println(ans);

        br.close();
    }
}
