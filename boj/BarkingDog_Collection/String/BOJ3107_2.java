package boj.BarkingDog_Collection.String;

/**
 * IPv6
 * 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ3107_2 {
    static final String defaults = "0000";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        String [] result = new String[8];

        Arrays.fill(result, defaults);

        if(ip.contains("::")){
            int idx = ip.indexOf("::");
            String prefix = ip.substring(0, idx);
            String suffix = ip.substring(idx + 2);

            StringBuilder temp = new StringBuilder();

            if(!suffix.equals("")){
                int cur = 7;
                for (int i = suffix.length() - 1; i >= 0; i--) {
                    char c = suffix.charAt(i);
                    if(c == ':' || i == 0){
                        if(i == 0 && c != ':'){
                            temp.append(c);
                        }
                        temp.reverse();
                        while (temp.length() < 4){
                            temp.insert(0, 0);
                        }
                        result[cur--] = temp.toString();
                        temp.setLength(0);
                    }
                    else temp.append(c);
                }
            }

            if(!prefix.equals("")){ // 1::
                int cur = 0;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if(c == ':' || i == prefix.length() - 1){
                        if(i == prefix.length() - 1 && c != ':'){
                            temp.append(c);
                        }
                        while (temp.length() < 4){
                            temp.insert(0, 0);
                        }
                        result[cur++] = temp.toString();
                        temp.setLength(0);
                    }
                    else temp.append(c);
                }
            }
        }
        else{
            int cur = 0;
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < ip.length(); i++) {
                char c = ip.charAt(i);
                if(c == ':' || i == ip.length() - 1){
                    if(i == ip.length() - 1 && c != ':'){
                        temp.append(c);
                    }
                    while (temp.length() < 4){
                        temp.insert(0, 0);
                    }
                    result[cur++] = temp.toString();
                    temp.setLength(0);
                }
                else temp.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(result[i]);
            if(i != 7) sb.append(":");
        }
        System.out.println(sb);
    }
}
