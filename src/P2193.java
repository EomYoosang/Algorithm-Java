import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193 {

    static long[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[91][2];
        // 이친수는 0으로 시작하지 않는다.
        // 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
        // n+1자리 이친수는 n자리 이친수 뒤에 0또는 1을 붙임
        // 뒷자리가 0으로 끝나는 이친수와 1로 끝나는 이친수를 따로 구분
        // 뒷자리가 0으로 끝나는 n+1자리 이친수는 dp[n][0] + dp[n][1]
        // 뒷자리가 1로 끝나는 n+1자리 이친수는 dp[n][0]
        // 즉 dp[n+1] = dp[n+1][0] + dp[n+1][1] = 2dp[n][0] + dp[n][1]
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;
        dp[3][0] = 1;
        dp[3][1] = 1;

        for (int i = 4; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
        br.close();
    }
}
