import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251 {
    static String str1, str2;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        d = new int[len1 + 5][len2 + 5];


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) d[i][j] = d[i - 1][j - 1] + 1;
                else d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }

        System.out.println(d[len1][len2]);

        br.close();
    }
}
