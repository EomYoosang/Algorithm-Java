import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
    static int[][] dp;
    static int t, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        dp = new int[2][41];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 1;
        dp[0][3] = 1;
        dp[1][3] = 2;

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for(int i=2;i<=n;i++){
                dp[0][i] = dp[0][i-1] + dp[0][i-2];
                dp[1][i] = dp[1][i-1] + dp[1][i-2];
            }
            System.out.println(String.valueOf(dp[0][n]) + ' ' + String.valueOf(dp[1][n]));
        }

        br.close();
    }
}
