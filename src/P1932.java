import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    static int n;
    static int[][] tng;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tng = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        dp[0][0] = tng[0][0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tng[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i - 1][j] + tng[i][j];
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + tng[i][j], dp[i - 1][j - 1] + tng[i][j]);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[n-1][i]);
        }

        System.out.println(ans);

        br.close();
    }
}
