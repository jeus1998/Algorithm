package boj.BarkingDog_Collection.String;

/**
 * 이름 궁합
 * 실버5
 */
import java.util.*;
import java.io.*;
public class BOJ15312 {
    static final int [] sequence = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            sb.append(sequence[A.charAt(i) - 'A']);
            sb.append(sequence[B.charAt(i) - 'A']);
        }
        while (true){
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sb.length() - 1; i++) {
                int sum = sb.charAt(i) - '0' + sb.charAt(i+1) - '0';
                sum %= 10;
                temp.append(sum);
            }
            sb = temp;
            if(sb.length()  == 2) break;
        }
        System.out.println(sb);
    }
}