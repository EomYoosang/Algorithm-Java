import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {
    static int t, n;
    static int[][] dp;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[2][n + 1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 2] + sticker[0][i], dp[1][i - 1] + sticker[0][i]);
                dp[1][i] = Math.max(dp[0][i - 2] + sticker[1][i], dp[0][i - 1] + sticker[1][i]);
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }


        br.close();
    }
}
