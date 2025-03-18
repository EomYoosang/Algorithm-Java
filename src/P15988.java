import java.io.*;

public class P15988 {
    static int t, n;
    static long[] dp;
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i <= 1000000; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %= MOD;
        }

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[n]) + '\n');
        }
        bw.flush();

        br.close();
    }
}
