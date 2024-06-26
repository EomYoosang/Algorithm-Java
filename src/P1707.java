import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1707 {

    static int K;
    static int V, E;
    private static List<List<Integer>> graph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (K-- > 0) {
            // V, E 입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            //
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            colors = new int[V + 1];
            boolean flag = true;
            for (int i = 1; i <= V; i++) {
                if (colors[i] != 0) continue;
                if (!flag) break;
                colors[i] = 1;
                Stack<Integer> s = new Stack<>();
                s.push(i);
                while (!s.empty() && flag) {
                    int num = s.pop();
                    List<Integer> e = graph.get(num);
                    int size = e.size();
                    for (int j = 0; j < size; j++) {
                        int cur = e.get(j);
                        if (colors[cur] == 0) {
                            colors[cur] = colors[num] * -1;
                            s.push(cur);
                        }
                        if (colors[cur] == colors[num]) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            bw.write(flag ? "YES" : "NO");
            bw.write("\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
