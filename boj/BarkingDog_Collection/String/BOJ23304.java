package boj.BarkingDog_Collection.String;

/**
 * 아카라카
 * 실버2
 */
import java.io.*;
public class BOJ23304 {
    static final String result1 = "IPSELENTI";
    static final String result2 = "AKARAKA";
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = function(input);
        if(answer == 1) System.out.println(result2);
        else System.out.println(result1);
    }
    public static int function(String input){
        int size = input.length();
        if(size == 1){
            return 1;
        }
        int check = size / 2;
        String prefix = input.substring(0, check);
        String suffix = input.substring(size - check);

        if(function(prefix) == 1 && function(suffix) == 1){
            if((prefix + suffix).equals(suffix + prefix)){
                return 1;
            }
        }
        return 0;
    }
}
