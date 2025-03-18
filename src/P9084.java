import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9084 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n;
            n = Integer.parseInt(br.readLine());
            int[] coin = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int m;
            m = Integer.parseInt(br.readLine());

            int[][] dp = new int[m + 1][n+1];
            Arrays.sort(coin);
            for (int i = 1; i <= n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1];
                    if (i >= coin[j]) {
                        dp[i][j] += dp[i - coin[j]][j];
                    }
                }
            }
            System.out.println(dp[m][n]);
        }

        br.close();
    }
}
