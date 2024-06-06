package boj.BarkingDog_Collection.String;

/**
 * IPv6
 * 골드5
 */
import java.io.*;
public class BOJ3107 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        boolean flag = input.contains("::")? true : false;

        if(!flag){
            for (int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i);
                if(tmp == ':' || i == input.length() - 1){
                    if(i == input.length() - 1) temp.append(tmp);
                    int st = temp.length();
                    for (int j = st; j < 4; j++) {
                        sb.append(0);
                    }
                    sb.append(temp);
                    temp.setLength(0);
                    if(i != input.length() -1)
                        sb.append(':');
                }
                else temp.append(tmp);
            }
            System.out.println(sb);
            return;
        }

        // :: 포함한 case

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ':') cnt++;
        }
        int count = 7 - cnt + 1;

        boolean already = false;

        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if(tmp == ':'){
                if(!already && input.charAt(i + 1) == ':'){
                    already = true;
                    if(i + 1 == input.length() - 1) count++;
                    int st = temp.length();
                    for (int j = st; j < 4; j++) {
                        sb.append(0);
                    }
                    sb.append(temp);
                    temp.setLength(0);
                    sb.append(':');
                    for (int j = 0; j < count; j++) {
                        sb.append("0000:");
                    }
                    if(i + 1 == input.length() - 1){
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    i += 1;
                }
                else{
                    int st = temp.length();
                    for (int j = st; j < 4; j++) {
                        sb.append(0);
                    }
                    sb.append(temp);
                    sb.append(":");
                    temp.setLength(0);
                }
            }
            else if(i == input.length() - 1){
                temp.append(tmp);
                int st = temp.length();
                for (int j = st; j < 4; j++) {
                    sb.append(0);
                }
                sb.append(temp);
            }
            else temp.append(tmp);
        }
        System.out.println(sb);
    }
}
