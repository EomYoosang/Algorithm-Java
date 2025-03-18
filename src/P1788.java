import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1788 {
    static int n;
    static int[] dp;
    static final int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[1000001];
        dp[0] = 0; dp[1] = 1;

        int mx = Math.abs(n);

        if(n >= 0){
            for(int i = 2; i <= n; ++i)
                dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        else{
            n = Math.abs(n);
            for(int i = 2; i <= n; ++i)
                dp[i] = (dp[i-2] - dp[i-1]) % mod;
        }

        if(dp[n] > 0) System.out.println(1);
        else if(dp[n] < 0) System.out.println(-1);
        else System.out.println(0);
        System.out.println(Math.abs(dp[n]));

        br.close();

    }
}
