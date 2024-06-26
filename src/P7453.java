import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        long arr[][] = new long[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        long ab[] = new long[n * n];
        long cd[] = new long[n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[k] = arr[i][0] + arr[j][1];
                cd[k++] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
        int start = 0;
        int end = n * n - 1;
        long cnt = 0;
        while (start < n * n && end >= 0) {
            long num1 = ab[start];
            long num2 = cd[end];
            long sum = num1 + num2;
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                int temp1 = 0, temp2 = 0;
                while (start < n * n && num1 == ab[start]) {
                    start++;
                    temp1++;
                }
                while (end >= 0 && num2 == cd[end]) {
                    end--;
                    temp2++;
                }
                cnt += (long) temp1 * temp2;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}