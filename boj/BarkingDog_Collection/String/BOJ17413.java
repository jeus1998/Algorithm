package boj.BarkingDog_Collection.String;

/**
 * 단어 뒤집기 2
 * 실버3
 */
import java.io.*;
public class BOJ17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb  = new StringBuilder();
        StringBuilder tp  = new StringBuilder(); // <tag>
        StringBuilder tp2 = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if(cnt > 0 || cur == '<'){
                if(cnt == 0){
                    sb.append(tp2.reverse());
                    tp2.setLength(0);
                }
                tp.append(cur);
                if(cur == '<'){
                   cnt++;
                }
                else if(cur == '>'){
                   cnt--;
                   if(cnt == 0){
                       sb.append(tp);
                       tp.setLength(0);
                   }
                }
            }
            else{
                if(cur == ' '){
                    sb.append(tp2.reverse());
                    sb.append(' ');
                    tp2.setLength(0);
                }
                else if(i == input.length()-1){
                    tp2.append(cur);
                    sb.append(tp2.reverse());
                    tp2.setLength(0);
                }
                else tp2.append(cur);
            }
        }
        System.out.println(sb);

    }
}
