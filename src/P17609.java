import java.io.*;

public class P17609 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            bw.write(String.valueOf(solve(s)) + '\n');
            bw.flush();
        }

        br.close();
        bw.close();
    }

    public static int solve(String s) {
        int strlen = s.length();
        int start = 0;
        int end = strlen - 1;
        String reverse = new StringBuilder(s).reverse().toString();
        if(s.equals(reverse)){
            return 0;
        }
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                StringBuilder delLeft = new StringBuilder(s).deleteCharAt(start);
                StringBuilder delRight = new StringBuilder(s).deleteCharAt(end);
                // 둘중 하나라도 성사되면 유사회문
                if (delLeft.toString().equals(delLeft.reverse().toString())
                        || delRight.toString().equals(delRight.reverse().toString())) {
                    return 1;
                }
                return 2;
            }
        }
        return 2;
    }
}
