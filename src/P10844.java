import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844 {
    static int n;
    static long[][] dp;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        dp[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                if (j != 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j != 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }

                dp[i][j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
        }
        ans %= MOD;

        System.out.println(ans);

        br.close();
    }
}
