import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[1000001][2];
        dp[1][0] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 2; i <= n; i++) {
            int num = dp[i - 1][0] + 1;
            int nt = i - 1;
            if (i % 3 == 0 && num > dp[i / 3][0] + 1) {
                num = dp[i / 3][0] + 1;
                nt = i / 3;
            }
            if (i % 2 == 0 && num > dp[i / 2][0] + 1) {
                num = dp[i / 2][0] + 1;
                nt = i / 2;
            }
            dp[i][0] = num;
            dp[i][1] = nt;
        }

        System.out.println(dp[n][0]);

        while (true) {
            System.out.print(String.valueOf(n) + ' ');
            if (n == 1) break;
            n = dp[n][1];
        }

        br.close();
    }
}
