import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11052 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
        br.close();
        // dp[i] = dp[i-1] + dp[1], dp[i-2] + dp[2], dp[i-3] + dp[3] ...
    }
}
