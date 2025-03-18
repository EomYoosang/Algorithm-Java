import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    static int n;
    static int[][] v;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        v = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
            v[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = v[0][0];
        dp[0][1] = v[0][1];
        dp[0][2] = v[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][2], dp[i - 1][1]) + v[i][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + v[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + v[i][2];
        }


        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));

        br.close();
    }
}
