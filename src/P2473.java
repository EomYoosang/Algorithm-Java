import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        long ans[] = new long[3];
        long sub = 3000000001L;
        for (int i = 0; i < n; i++) {
            long target = arr[i];
            int start = 0;
            int end = n - 1;
            while (start < end && sub != 0) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                long sum = arr[start] + arr[end] + target;
                if(Math.abs(sum)<sub){
                    ans[0] = arr[start];
                    ans[1] = arr[end];
                    ans[2] = target;
                    sub = Math.abs(sum);
                }
                if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        Arrays.sort(ans);
        for (int i = 0; i < 3; i++) {
            bw.write(String.valueOf(ans[i]));
            bw.write(' ');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
