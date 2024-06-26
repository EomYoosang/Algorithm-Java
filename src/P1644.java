import java.io.*;
import java.util.Vector;

public class P1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        if (n == 1) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        boolean prime[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }

        }
        Vector<Integer> v = new Vector<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                v.add(i);
            }
        }
        int start = 0, end = 0;
        int sum = 0;
        int cnt = 0;
        int s = v.size();
        while (end <= s) {
            if (sum > n) {
                // 연속된 소수의 합이 n보다 크거나 같으면 그중 가장 작은 소수의 값을 뺌
                sum -= v.get(start++);
            } else if(end == s){
                break;
            } else {
                // 연속된 소수의 합이 n보다 작으면 그 다음 큰 소수를 더함
                // ** end는 다음에 더할 소수
                // v[0] = 2이므로 가장 첫 분기에 v[end] = v[0] = 2를 더함
                sum += v.get(end++);
            }
            if (sum == n) cnt++;

        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
