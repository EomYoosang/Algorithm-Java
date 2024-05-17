import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {
    static int n;
    static int m;

    public static int lowerBSearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        // 조건에 만족하면 현재 값 리턴
        if (arr[mid] == target && (mid == 0 || arr[mid - 1] < arr[mid])) {
            return mid;
        }
        // 현재 값(arr[mid])가 target보다 크거나 같으면 더 아래범위 탐색
        if (arr[mid] >= target) {
            return lowerBSearch(arr, target, low, mid - 1);
        } else {  // 현재 값(arr[mid])가 target 보다 작으면 위 범위 탐색
            return lowerBSearch(arr, target, mid + 1, high);
        }
    }

    public static int upperBSearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target && (mid == n - 1 || arr[mid] < arr[mid + 1])) {
            return mid;
        }

        if (target >= arr[mid]) {
            return upperBSearch(arr, target, mid + 1, high);
        } else {
            return upperBSearch(arr, target, low, mid - 1);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.valueOf(br.readLine());
        int num[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.valueOf(st.nextToken());
        }
        m = Integer.valueOf(br.readLine());
        int card[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            card[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < m; i++) {
            int upper = upperBSearch(num, card[i], 0, n - 1);
            int lower = lowerBSearch(num, card[i], 0, n - 1);
            if (upper == -1) {
                bw.write("0\n");
            } else {
                bw.write(String.valueOf(upper - lower + 1));
                bw.write("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
