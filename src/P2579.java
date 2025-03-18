import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    static int n;
    static int[] stair;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stair = new int[n + 1];
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        if(n==1){
            System.out.println(stair[1]);
            return;
        }
        //dp[i][1] 은 연속계단을 밟은 경우
        //dp[i][0] 은 연속계단을 안밝은 경우
        dp[0][0] = dp[0][1] = 0;
        dp[1][0] = stair[1];
        dp[1][1] = 0;
        dp[2][0] = stair[2];
        dp[2][1] = stair[1]+stair[2];
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][0] + stair[i];
            dp[i][0] = Math.max(dp[i - 2][1] + stair[i], dp[i - 2][0] + stair[i]);
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));

        br.close();
    }
}
