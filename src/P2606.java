import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2606 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int line = Integer.valueOf(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        check[1] = true;
        int cnt = 0;
        Stack<Integer> s = new Stack<>();
        s.push(1);
        while (!s.empty()) {
            int currentNode = s.pop();
            for (int i = 0; i <= n; i++) {
                if (arr[currentNode][i] == 1 && !check[i]) {
                    s.push(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        br.close();
        bw.close();
    }
}
