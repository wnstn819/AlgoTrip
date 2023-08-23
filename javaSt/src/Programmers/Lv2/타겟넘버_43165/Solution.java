package Programmers.Lv2.타겟넘버_43165;

class Solution {
    public static int answer =0;
    public int solution(int[] numbers, int target) {

        DFS(numbers,0,0,target);

        return answer;
    }
    public void DFS(int[] numbers,int sum,int num,int target){
        if(num == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }


        DFS(numbers,numbers[num] + sum,num+1,target);
        DFS(numbers,sum - numbers[num],num+1,target);



    }
}