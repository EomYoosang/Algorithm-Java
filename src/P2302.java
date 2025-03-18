import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2302 {
    static int n, m;
    static int[] vip;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        vip = new int[m + 2];
        dp = new long[41];
        vip[0] = 0;
        vip[m + 1] = n + 1;

        for (int i = 1; i <= m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int size = vip.length;

        long ans = 1;
        for (int i = 1; i < size; i++) {
            ans *= dp[vip[i] - vip[i - 1] - 1];
        }

        System.out.println(ans);
        br.close();
    }
}
