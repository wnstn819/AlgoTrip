import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] arr = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        List<Mineral> list = new ArrayList<>();
        int total_number = 0;
        
        for(int m : picks){
            total_number += m;
        }
        
        for(int i=0;i<(minerals.length/5) + 1 ;i++){
            
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
        
            for(int j=i*5;j<(i*5)+5 && j<minerals.length;j++){
                int num =0;
                
                switch(minerals[j].charAt(0)){
                        
                    case 'd':
                        dia += arr[0][num];
                        iron += arr[1][num];
                        stone += arr[2][num];
                        break;
                    case 'i':
                        num=1;
                        dia += arr[0][num];
                        iron += arr[1][num];
                        stone += arr[2][num];
                        break;
                    case 's':
                        num=2;
                        dia += arr[0][num];
                        iron += arr[1][num];
                        stone += arr[2][num];
                        break;
                        
                
                }
            }
            list.add(new Mineral(dia,iron,stone));
        }
        
        System.out.println(list.size());
        if(total_number < list.size()){
         list = list.subList(0,total_number);   
        }
         
        list.sort(((o1, o2) -> (o2.stone - o1.stone)));
    
        
        for(Mineral m : list) {
			int diamond = m.diamond;
			int iron = m.iron;
			int stone = m.stone;
            
			if(picks[0] > 0) {
				answer += diamond;
				picks[0]--;
				continue;
			}

			if(picks[1] > 0) {
				answer += iron;
				picks[1]--;
				continue;
			}

			if(picks[2] > 0) {
				answer += stone;
				picks[2]--;
			}
            
		}
        return answer;
    }
    
    class Mineral {
		private int diamond;
		private int iron;
		private int stone;

		public Mineral(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}
	}
    
}
