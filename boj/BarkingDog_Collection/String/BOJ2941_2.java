package boj.BarkingDog_Collection.String;

/**
 * 크로아티아 알파벳
 * 실버5
 * String = String.replace(oldChar, newChar) 사용하기
 */
import java.io.*;
public class BOJ2941_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] check = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < check.length; i++) {
             if(input.contains(check[i])){
                 input = input.replace(check[i], "?");
             }
        }
        System.out.println(input.length());
    }
}
