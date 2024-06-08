package boj.BarkingDog_Collection.String;

/**
 * 크로아티아 알파벳
 * 실버5
 */
import java.util.*;
import java.io.*;
public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] check = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();

        for (int i = 0; i < check.length; i++) {
            String target = check[i];
            int size = target.length();
            while (input.contains(target)){
                int idx = input.indexOf(target);
                String prefix = input.substring(0, idx);
                String suffix = input.substring(idx + size);
                input = prefix + "?" + suffix;
            }
        }
        System.out.println(input.length());
    }
}
