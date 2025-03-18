import java.io.*;
import java.util.StringTokenizer;

public class P10942 {
    static int n, m, s, e;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (dp[i][j]) continue;
                if (dp[i + 1][j - 1] && arr[i] == arr[j]) {
                    dp[i][j] = true;
                }
            }
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            String result = dp[s][e] ? "1" : "0";
            bw.write(result + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
