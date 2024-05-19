import java.io.*;

public class P1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int k = Integer.valueOf(br.readLine());
        // k = (i - 1) + j
        // B[x] = A[i][j] = i * j
        // k에 해당하는 A[i][j]를 찾아야 함

        int start = 1;
        int end = k; // B[k]<=k이기 때문
        int ans = 0;
        // B[k]를 찾는 이분탐색
        // start<=end가 되면 검사 끝
        while(start<=end){
            int mid = (start+end)/2;
            // min(mid/i, n) : mid 보다 작거나 같은 수의 합
            int sum = 0;
            for(int i=1;i<=n;i++){
                sum += Math.min(mid/i, n);
            }
            // mid보다 작은 수(sum)가 k보다 적으면
            if(k>sum) {
                start = mid+1;
                // B[k] 주변 숫자(k-1,k-2... ,k+1, k+2..) 가 B[k]와 같을 수 있음
                // mid보다 작은 수(sum)가 k보다 같거나 많으면 B[k]는 mid일 수도, mid보다 큰 수 일수도
                // start, end 범위가 좁아질 수록 B[k]에 가까워짐
            } else {
                ans = mid;
                end = mid-1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
