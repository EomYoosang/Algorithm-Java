import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1915 {
    static int n, m;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = s.charAt(j-1);
                board[i][j] = Character.getNumericValue(c);
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 1) {
//                    if (board[i - 1][j - 1] == 1 && board[i][j - 1] == 1 && board[i - 1][j] == 1) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                    } else {
//                        dp[i][j] = 1;
//                    }

                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result * result);

        br.close();
    }
}























// 0 0 0 0 0
// 0 1 1 1 0
// 0 1 1 1 1
// 0 1 1 1 1
// 0 0 1 1 1


// 0 0 0 0 0
// 0 1 1 1 0
// 0 1 2 2 1
// 0 1 2 3 2
// 0 0 1 2 ?

// 0 0 0 0 0
// 0 0 1 1 1
// 0 1 1 1 1
// 0 1 1 1 1
// 0 1 1 1 1


// 0 0 0 0 0
// 0 0 1 1 1
// 0 1 1 2 2
// 0 1 2 2 3
// 0 1 2 3 ?