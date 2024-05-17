import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
    public static int BSearch(int arr[], int target, int low, int high) {
        if(low>high){
            return -1;
        }
        int mid = (low + high) / 2;
        long sum = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }

        if (sum >= target) {
            return Math.max(BSearch(arr, target, mid + 1, high), mid);
        } else {
            return BSearch(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int tree[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(tree);
        int max = tree[n-1];

        int result = BSearch(tree, m, 0, max);
        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
