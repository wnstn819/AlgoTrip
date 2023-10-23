class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
       
        int n = gcd(arrayA);
        int ans = 1;
        for(int i : arrayB){
            if(i%n ==0){
                ans = 0;
                break;
            }else{
                continue;
            }
        }
        
        answer = Math.max(answer,ans == 0 ? 0 : n);
        
        int m = gcd(arrayB);
        int ansB = 1;
        for(int i : arrayA){
            if(i%m ==0){
                ansB = 0;
                break;
            }
            else{
                continue;
            }
        }
        answer = Math.max(answer,ansB == 0 ? 0 : m );
        return answer;
    }
        public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getGcd(result, arr[i]);
        }
            return result;  
        }      

        public static int getGcd(int a, int b) {
            if (b == 0) return a;
        return getGcd(b, a % b);
        }
}