package boj.workbook_8708;

/**
 * 타노스 -
 */
import java.io.*;
import java.util.*;
public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int count0 = 0; // 0 개수
        int count1 = 0; // 1 개수
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) =='0') count0++;
            else count1++;
        }
        count0 /= 2;
        count1 /= 2;

        boolean [] visited = new boolean[s.length()];
        int index = s.length() - 1;
        while (count0 > 0){
            if(s.charAt(index) == '0'){
                visited[index] = true;
                count0--;
            }
            index--;
        }
        index = 0;
        while (count1 > 0){
            if(s.charAt(index) == '1'){
                visited[index] = true;
                count1--;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!visited[i]){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }
}