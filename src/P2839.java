import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int ans = -1;

        int five = n / 5;

        while (five >= 0) {
            if ((n - five * 5) % 3 == 0) {
                ans = five + (n - five * 5) / 3;
                break;
            }
            five--;
        }

        System.out.println(ans);

        br.readLine();
    }
}
