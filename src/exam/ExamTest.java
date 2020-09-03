package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/9 22:03
 */
public class ExamTest {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder[] strs = new StringBuilder[N];

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strs[i] = new StringBuilder(sc.next());
        }
        for (int i = 0; i < N; i++) {
            StringBuilder str = strs[i];
            for (int j = 2; j < str.length(); j++) {
                //AAA
                if(str.charAt(j) == str.charAt(j - 1) && str.charAt(j - 1) == str.charAt(j - 2)) {
                    str.deleteCharAt(j);
                    j --;
                    continue;
                }
                if(j > 2) {
                    //AABB
                    if(str.charAt(j - 3) == str.charAt(j - 2) && str.charAt(j - 1) == str.charAt(j)) {
                        str.deleteCharAt(j);
                        j --;
                    }
                }

            }
            ans.add(str.toString());
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
