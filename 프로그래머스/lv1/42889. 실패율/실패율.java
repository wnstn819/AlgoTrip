import java.util.*;
class Solution {
    public static double[][] arr;
    
    
    public int[] solution(int N, int[] stages) {
        arr = new double[N+2][3];
        
        int[] answer = {};
            
        
        for(int i : stages){
            //map.put(i,map.getOrDefault(i,0)+1);
            arr[i][0] ++;
        }
        
        int count = stages.length;
        
      
        
        for(int i= 1 ;i<N+1;i++){
            
            if(arr[i][0] == 0){
                arr[i][1] = 0;
                arr[i][2] = i; 
                continue;
            }
            arr[i][1] = arr[i][0]/count;
            arr[i][2] = i;
            count -= arr[i][0];
        }
        // for(double[] i: arr){
        //    System.out.println(i[0] + " " + i[1] + " " +i[2]);
        // }
        
        Arrays.sort(arr, (o1, o2) -> Double.compare( o2[1],o1[1]));
             
        answer = new int[N];
        
        int index = 1;
        for(double[] i: arr){
            if(i[2] !=0){
                answer[index-1] = (int)i[2];
                index++;
            }
        }
        
        
         
        return answer;
    }
}