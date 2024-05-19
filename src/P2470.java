import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int low = 0;
        int high = n - 1;
        int ans[] = new int[2];
        ans[0] = arr[low];
        ans[1] = arr[high];
        int min = 2000000001;

        while (low < high) {
            int sum = arr[low] + arr[high];
            if (Math.abs(sum) < min) {
                ans[0] = arr[low];
                ans[1] = arr[high];
                min = Math.abs(sum);
            }
            if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }

        Arrays.sort(ans);

        bw.write(String.valueOf(ans[0]) + ' ' + String.valueOf(ans[1]));

        bw.flush();
        br.close();
        bw.close();
    }
}