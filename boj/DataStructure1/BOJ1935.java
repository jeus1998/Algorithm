package boj.DataStructure1;

/**
 * 후위 표기식2
 * 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        HashMap<String, Double> map = new HashMap<>();
        for (int i = 'A'; i < 'A' + n; i++) {
            double in = Integer.parseInt(br.readLine());
            String str = Character.toString(i);
            map.put(str, in);
        }
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            switch (a){
                case '+':{
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case '-':{
                    double tmp1 = stack.pop();
                    double tmp2 = stack.pop();
                    stack.push(tmp2-tmp1);
                    break;
                }
                case '*':{
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case '/':{
                    double tmp1 = stack.pop();
                    double tmp2 = stack.pop();
                    stack.push(tmp2 / tmp1);
                    break;
                }
                case '%':{
                    double tmp1 = stack.pop();
                    double tmp2 = stack.pop();
                    stack.push( tmp2 % tmp1);
                    break;
                }
                default:{
                    stack.push(map.get(Character.toString(a)));
                }
            }
        }
        double result= stack.pop();
        System.out.printf("%.2f", result);
    }
}
/*

AA+A+
-> (A+A) + A

ABC*+DE/-
-> A+(B*C) -(D/E)

-> 1 + 6  - 0.8 = 7 - 0.8 = 6.2
A B C D E
1 2 3 4 5

 */