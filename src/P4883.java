import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4883 {

    static int n;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        while (true) {
            k++;
            n = Integer.parseInt(br.readLine());
            graph = new int[3][n];
            dp  = new int[3][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j <= 3; j++) {
                    graph[j][i] = Integer.parseInt(st.nextToken());
                }
            }



            String flag = br.readLine();
            if (flag == "0") break;
        }

        br.close();
    }
}
