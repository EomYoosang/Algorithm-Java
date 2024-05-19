import java.io.*;
import java.util.StringTokenizer;

public class P2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int start = 0, end = n - 1;
        int min = 2000000001;
        int ansX = 0, ansY = n - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansX = start;
                ansY = end;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(String.valueOf(arr[ansX]) + " " + String.valueOf(arr[ansY]));
        bw.flush();
        br.close();
        bw.close();
    }
}
