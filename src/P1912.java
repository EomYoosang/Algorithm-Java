import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {

    static int n;
    static int[] num;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        max = dp[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+num[i], num[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        br.close();
    }
}
