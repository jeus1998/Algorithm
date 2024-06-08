package boj.BarkingDog_Collection.String;

/**
 * 한국이 그리울 땐 서버에 접속하지
 * 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ9996 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        StringBuilder sb = new StringBuilder();

        String [] split = pattern.split("\\*");

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            String check = br.readLine();
            if(check.contains(split[0]) && check.indexOf(split[0]) == 0){
                check = check.substring(split[0].length());
            }
            else flag = false;

            if(!flag || !check.contains(split[1]) || check.lastIndexOf(split[1]) + split[1].length() != check.length()){
                flag = false;
            }

            if(flag) sb.append("DA");
            else sb.append("NE");

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
