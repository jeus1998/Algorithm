package boj.workbook_8708;

/**
 * 문자열 교환 - 실버1
 * 슬라이딩 윈도우 기법, 원형 <-> 배열 연결해서 개수 count
 */
import java.io.*;
public class BOJ_1522_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)== 'a') cnt++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(input).append(input);
        String target = sb.toString();
        int b_count = 0;
        for (int i = 0; i < cnt; i++) {
            if(target.charAt(i) =='b') b_count++;
        }
        int min = b_count;
        for (int i = cnt; i < target.length(); i++) {
            if(target.charAt(i) =='b') b_count++;
            if(target.charAt(i - cnt) =='b') b_count--;
            min = Math.min(min, b_count);
        }
        System.out.println(min);
    }
}