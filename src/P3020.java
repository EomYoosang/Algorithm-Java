import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3020 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int up[] = new int[n / 2];
        int down[] = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            down[i] = Integer.valueOf(br.readLine());
            up[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(down);
        Arrays.sort(up);
        int min = n;
        int cnt = 0;
        for (int i = 1; i < h + 1; i++) {
            int conflict = BSearch(0, n / 2, i, down) + BSearch(0, n / 2, h - i + 1, up);
            if (conflict == min) {
                cnt++;
            }
            if (conflict < min) {
                min = conflict;
                cnt = 1;
            }
        }
        bw.write(String.valueOf(min) + ' ' + String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int BSearch(int low, int high, int h, int[] arr) {
        while (low < high) {
            int mid = (low+high)/2;
            if(arr[mid] >= h) {
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return arr.length - high;
    }
}
