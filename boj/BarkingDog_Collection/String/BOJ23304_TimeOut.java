package boj.BarkingDog_Collection.String;

/**
 * 아카라카
 * 실버2
 */
import java.io.*;
public class BOJ23304_TimeOut {
    static final String result1 = "IPSELENTI";
    static final String result2 = "AKARAKA";
    static StringBuilder sb;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        function(input);
        if(flag) System.out.println(result2);
        else System.out.println(result1);
    }
    public static void function(String input){
        if(input.length() == 1 ){
            return;
        }

        sb = new StringBuilder(input);
        if(!sb.reverse().toString().equals(input)){
            flag = false;
            return;
        }

        // 접두사 접미사
        int size = input.length() / 2;
        String prefix = input.substring(0, size);
        String suffix = input.substring(input.length() - size);

        sb = new StringBuilder(prefix);
        if(!sb.reverse().toString().equals(prefix)){
            flag = false;
            return;
        }

        sb = new StringBuilder(suffix);
        if(!sb.reverse().toString().equals(suffix)){
            flag = false;
            return;
        }
        function(suffix);
        function(prefix);
    }
}
