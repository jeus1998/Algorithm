package boj.workbook_8708;

/**
 * 수 이어 쓰기 -
 */
import java.io.*;
public class BOJ_1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        char [] chars = input.toCharArray();
        int idx = 0;
        int number = 0;
        while (true){
            String number_str = String.valueOf(++number);
            int size = number_str.length();
            for (int i = 0; i < size; i++) {
                if(number_str.charAt(i) == chars[idx]){
                    idx++;
                    if(idx == chars.length){
                        System.out.println(number_str);
                        return;
                    }
                }
            }
        }
    }
}