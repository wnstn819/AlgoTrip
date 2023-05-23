import java.io.*;
import java.util.*;

public class Main {
    public static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();

        Stack<Character> stack = new Stack<>();
        for(int i =0; i<str.length() ; i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.size() !=0 && str.charAt(i-1) == '('){
                    stack.pop();
                    result += stack.size();

                }else{
                    stack.pop();
                    result +=1;
                }

            }
        }

        System.out.println(result);




    }

}
