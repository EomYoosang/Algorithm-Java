import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14002 {
    static int n;
    static int[] a;
    static int[] dp;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        a = new int[n + 1];
        b = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            b[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    b[i] = j;
                }
            }
        }

        int ans = 0;
        int ansI = 0;
        for (int i = 1; i <= n; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
                ansI = i;
            }
        }

        System.out.println(ans);

        int[] arr = new int[ans];
        int index = ans - 1;
        while (ansI > 0) {
            arr[index] = a[ansI];
            ansI = b[ansI];
            index--;
        }
        for (int i = 0; i < ans; i++) {
            sb.append(arr[i] + " ");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
