import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1011 {
    static int t;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int rt = (int) Math.sqrt(distance);

            int result = 0;

            if (distance == rt * rt) {
                result = 2 * rt - 1;
            } else if (rt * rt < distance && distance <= rt * rt + rt) {
                result = 2 * rt;
            } else {
                result = 2 * rt + 1;
            }

            System.out.println(result);
        }
    }
}
