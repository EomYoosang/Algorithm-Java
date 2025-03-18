import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1005 {
    static int t;
    static int n, k;
    static int[] d;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // n, k 입력
            // n : 노드 개수
            // k : 간선 개수
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            // n번 건물 건축에 드는 시간
            d = new int[n + 1];

            // 그래프
            List<List<Integer>> list = new ArrayList<List<Integer>>();

            for (int i = 0; i < n + 1; i++)
                list.add(new ArrayList<Integer>());

            // 노드로 들어오는 간선의 개수 (선행건물의 수)
            int[] indegree = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                d[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                // v1 -> v2
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                indegree[v2]++;
            }

            w = Integer.parseInt(br.readLine());

            // 방향을 가짐 + 사이클이 없음 = direct acyclic graph(dag) => 위상정렬
            // dfs or bfs로 해결 시 시간초과!!!

            Queue<Integer> q = new LinkedList<Integer>();
            int[] result = new int[n+1];

            for(int i=1; i<=n; i++) {
                result[i] = d[i];

                // 연결되지 않은 노드(첫건물)
                if(indegree[i] == 0)
                    q.offer(i);
            }

            while(!q.isEmpty()) {
                // Queue에 있는 건물 조회
                int node = q.poll();
                // result[i] : i번 건물을 짓는데 걸리는 시간
                // 선행건물을 건축하는데 드는 시간들을 전부 조회 => 최대값에 현재건물 건축시간 추가
                for(Integer i : list.get(node)) {
                    result[i] = Math.max(result[i], result[node] + d[i]);
                    indegree[i]--;

                    if(indegree[i] == 0)
                        q.offer(i);
                }
            }
            System.out.println(result[w]);
        }

    }

}
