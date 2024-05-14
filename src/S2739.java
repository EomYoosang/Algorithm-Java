import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2739 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) {
            System.out.print(n + " * " + i + " = " + n * i + "\n");
        }
        br.close();
    }
}
