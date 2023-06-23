

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length;
        int m = park[0].length();
        int[][] map = new int[n][m];
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for(int i =0;i<n;i++){
            
            char[] arr = park[i].toCharArray();
            for(int j = 0;j<m;j++){
                if(arr[j] == 'S'){
                    map[i][j]= 1;
                    x= i;
                    y= j;
                }else if(arr[j] == 'X'){
                    map[i][j] = 2;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        
        for(int j =0; j<routes.length;j++){
            char[] arr = routes[j].toCharArray();
            int nx=x;
            int ny =y;
            boolean check = true;
            switch(arr[0]){
                case 'E':
                    ny += arr[2] - '0';
                    for(int i=y+1;i<=ny;i++){
                        if(0<=i && i<m && map[x][i] != 2){
                            continue;
                        }else{
                            check =false;
                            break;
                        }
                    }
                    if(check){
                        y = ny;
                    }
                    break;
                case 'S' :
                    
                      nx += arr[2] - '0';
                    for(int i=x+1;i<=nx;i++){
                        if(0<=i && i<n && map[i][y] != 2){
                            continue;
                        }else{
                            check =false;
                            break;
                        }
                    }
                    if(check){
                        x = nx;
                    }
                    
                    break;
                case 'W' :
                      ny -= arr[2] - '0';
                    for(int i=y-1;i>=ny;i--){
                        if(0<=i && i<m && map[x][i] != 2){
                            continue;
                        }else{
                            check =false;
                            break;
                        }
                    }
                    if(check){
                        y = ny;
                    }
                    break;
                case 'N':
                       nx -= arr[2] - '0';
                    for(int i=x-1;i>=nx;i--){
                        if(0<=i && i<n && map[i][y] != 2){
                            continue;
                        }else{
                            check =false;
                            break;
                        }
                    }
                    if(check){
                        x = nx;
                    }
                    break;
            }
//             switch(arr[0]){
//                 case 'E':
//                     ny = y+(arr[2]-'0');
//                     for(int j=y;j<=ny;j++){
//                         if(0<= j && j<m && map[x][j] != 2){
//                             continue;
//                         }else{
//                             check= true;
//                             break;
//                         }
//                     }
//                     if(!check){
//                         y += arr[2] - '0';      
//                     }
                    
                  
//                     break;
//                 case 'S' :
//                     nx = x+(arr[2]-'0');
//                     for(int j=x;j<=nx;j++){
//                          if(0<= j && j<n && map[j][y] != 2){
//                             continue;  
//                     }else{
//                              check= true;
//                              break;
//                          }
//                     }
//                     if(!check){
//                      x += arr[2] - '0';  
//                     }
//                     break;
//                 case 'W' :
//                     ny = y-(arr[2]-'0');
//                     for(int j=y;j>=ny;j--){
//                         if(0<= j && j<m && map[x][j] != 2){
//                             continue;
//                         }else{
//                             check= true;
//                             break;
//                         }
//                     }
//                     if(!check){
//                     y -= arr[2] - '0';  
//                     }
//                     break;
//                 case 'N':
//                     nx = x+(arr[2]-'0');
//                     for(int j=x;j>=nx;j--){
//                          if(0<= j && j<n && map[j][y] != 2){
//                             continue;  
//                     }else{
//                              check= true;
//                              break;
//                          }
//                     }
//                     if(!check){
//                      x += arr[2] - '0';  
//                     }
//                     break;
//             }
            
            
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}