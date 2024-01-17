import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
    	 char a = 0;
    	for(int i=1 ; i<101; i++) {
    		
         a = (char)System.in.read();
         if((int)a<65 || (int)a>122) {
        	 return;
         }
         if((int)a != 13) {
        	 System.out.print(a);
        	 
         
         }else if((int)a == 13) {
        	 return;
         }
         
         if(i%10 == 0 ) {
         System.out.println();
         }
    	}
       return;
        
    }
}