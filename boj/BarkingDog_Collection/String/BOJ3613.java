package boj.BarkingDog_Collection.String;

/**
 * Java vs C++
 * 실버3
 */
import java.util.*;
import java.io.*;
public class BOJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '_') continue;
            if('a' <= input.charAt(i) && input.charAt(i) <= 'z') continue;
            if('A' <= input.charAt(i) && input.charAt(i) <= 'Z') continue;
            System.out.println("Error!");
            return;
        }

        if(input.contains("_")){
            if(input.indexOf("_") == 0 || input.lastIndexOf("_") == input.length() - 1){
                System.out.println("Error!");
                return;
            }

            String lower = input.toLowerCase();
            if(!lower.equals(input)){ // c++형식인데 대문자가 있으면
                System.out.println("Error!");
                return;
            }

            String [] split = input.split("_");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if(split[i].length() == 0){
                    System.out.println("Error!");
                    return;
                }
                if(i == 0){
                    sb.append(split[i]);
                }
                else{
                    String first = split[i].substring(0,1);
                    sb.append(first.toUpperCase()).append(split[i].substring(1));
                }
            }
            System.out.println(sb);
        }
        else{
            if(input.length() == 0){
                System.out.println();
                return;
            }
            if(input.charAt(0) > 'z' || input.charAt(0) < 'a'){
                System.out.println("Error!");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) > 'z' || input.charAt(i) < 'a'){
                    sb.append("_").append(Character.toString(input.charAt(i)).toLowerCase());
                }
                else sb.append(input.charAt(i));
            }
            System.out.println(sb);
        }
    }
}
