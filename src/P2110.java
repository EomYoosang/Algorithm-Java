import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    public static int BinarySearch(int arr[], int size, int c, int low, int high) {
        if (low > high) {
            return 0;
        }

        // 검증하고 싶은 값
        int mid = (low + high) / 2;
        // 첫번째 집에 공유기 설치
        int cnt = 1;
        // 첫번째 집 좌표
        int prev_house = arr[0];
        for (int i = 1; i < size; i++) {
            // 두집 사이의 거리가 mid보다 큰 경우 공유기 설치
            // cnt가 c보다 작다면 공유기를 더 배치해야함, mid값 감소 필요
            // cnt가 c보다 크다면 공유기를 적게 배치해야함, mid값 증가 필요
            // cnt가 c와 같은 경우에도 최대값은 mid보다 클 수도 있음, mid값 증가 필요
            if (arr[i] - prev_house >= mid) {
                cnt++;
                prev_house = arr[i];
            }
        }
        if (cnt >= c) {
            return Math.max(mid, BinarySearch(arr, size, c, mid + 1, high));
        } else {
            return BinarySearch(arr, size, c, low, mid - 1);
        }
    }

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        bw.write(String.valueOf(BinarySearch(arr, n, c,0, arr[n-1] - arr[0])));

        bw.flush();
        br.close();
        bw.close();
    }
}
