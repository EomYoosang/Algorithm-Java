import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {

    static int t;
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dp = new int[m + 1][m + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) dp[i][j] = 1;
                    else if (i == j) dp[i][j] = 1;

                    else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[m][n]);
        }

        br.close();
    }
}
