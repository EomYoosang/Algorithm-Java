import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12865 {
    static int n, k;
    static int[][] dp;
    static int[][] arr;
    static int currentW = 0, currentV = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][2];
        dp = new int[n + 1][k + 1];
        // [i번 물건까지 넣음][최대 무게 j까지 넣음]

        // 0번째 물건을 넣으면 최대 무게에 상관없이 가치는 0
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
        }
        for(int i=0;i<=k;i++){
            dp[0][i] = 0;
        }

        // 0~i번 물건에 0~K무게에 들어가는 최대 가치
        for (int i = 1; i <= n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - w >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}
