import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {
    static int n, ans, mp;
    static int[] t, p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(mp, dp[i]);
            if (i + t[i] - 1 <= n) {
                dp[i + t[i] - 1] = Math.max(dp[i - 1] + p[i], dp[i + t[i] - 1]);
            }
            mp = Math.max(mp, dp[i]);
        }

        System.out.println(mp);
        br.close();
    }
}
