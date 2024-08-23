class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int number = n;
        int count =0;
        while(number>1){
            number = number/2;
            count++;
            
        }
        int start = 1;
        int end = n;
        
        while(count > 1){
            int sum = start + end;
            if(a > sum/2 && b > sum/2){
                start = sum/2 + 1;
                count--;
            }else if(a <= sum/2 && b <= sum/2){
                end = sum/2;
                count--;
            }else{
                break;
            }
            
            
        }

        return count;
    }
}