import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {

    public static int BinarySearch(int arr[], int target, int low, int high) {
        if (low > high) {
            return 0;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return 1;
        } else if (arr[mid] > target)
            return BinarySearch(arr, target, low, mid - 1);
        else
            return BinarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr1[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        int arr2[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            bw.write(String.valueOf(BinarySearch(arr1,arr2[i],0,n-1)));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
