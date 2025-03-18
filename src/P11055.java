import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11055 {
    static int n, ans;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        ans = num[0];

        for (int i = 0; i < n; i++) {
            dp[i] = num[i];
            // i번째 이전 전체 탐색
            // n이 최대 1000이므로 시간초과 X (O(n^))
            for (int j = 0; j < i; j++) {
                // j번째 수가 i번째 수보다 작을 때만 최대값 갱신 가능
                if (num[i] > num[j]) {
                    // 1~j 중 dp[i]가 최대가 되는 수 선택
                    dp[i] = Math.max(dp[i], dp[j] + num[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
