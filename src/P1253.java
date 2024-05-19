import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int start = 0, end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    if (start == i) {
                        start++;
                    }
                    else if (end == i) {
                        end--;
                    } else {
                        result++;
                        break;
                    }
                }
                sum = arr[start] + arr[end];
                if (sum > target) {
                    end--;
                }
                if (sum < target) {
                    start++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
