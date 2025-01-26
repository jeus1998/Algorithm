package boj.workbook_8708;

/**
 * 비밀번호 발음하기 - 실버5
 */
import java.io.*;
public class BOJ_4659 {
    static final char [] memo = {'a', 'e', 'i', 'o', 'u'};
    static final String ACCEPTABLE = "is acceptable.";
    static final String NOT_ACCEPTABLE = "is not acceptable.";
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb =  new StringBuilder();
         while (true){
             String password = br.readLine();
             if(password.equals("end")) break; // 종료 조건
             boolean contains = false; // 모음 포함 여부
             char[] array = password.toCharArray();
             int cnt1 = 0;
             int cnt2 = 0;
             for (int i = 0; i < array.length; i++) {
                 boolean flag = true;
                 for (int j = 0; j < 5; j++) {  // 모음 체크
                     if(array[i] == memo[j]) {
                         contains = true;
                         cnt1++;
                         cnt2 = 0;
                         flag = false;
                         break;
                     }
                 }
                 if(flag){
                     cnt1 = 0;
                     cnt2++;
                 }
                 if(cnt1 == 3 || cnt2 == 3){
                     contains = false;
                     break;
                 }
                 if(i != 0 && array[i] == array[i-1]){
                     if(array[i] == 'e' || array[i] == 'o'){
                         continue;
                     }
                     contains = false;
                     break;
                 }
             }
             sb.append("<").append(password).append("> ");
             if(contains){
                 sb.append(ACCEPTABLE);
             }
             else sb.append(NOT_ACCEPTABLE);
             sb.append("\n");
         }
        System.out.println(sb);
    }
}
