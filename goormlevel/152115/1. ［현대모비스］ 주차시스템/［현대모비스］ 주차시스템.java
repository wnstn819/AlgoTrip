import java.io.*;
import java.util.*;
class Main {
		static int N,M,max = 0;
		static int[][] map;
		static int[] dx = {0,0,1,-1};
		static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());		
			}
		}
		
		for(int i =0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j] ==0 || map[i][j] ==2){
					BFS(i,j);	
				}
			}
		}
		System.out.println(max);
	}
	
	
	public static void BFS(int x, int y){
		int sum =0;
		sum += valueCount(map[x][y]);
		map[x][y] = 3;
		Queue<Area> que = new LinkedList(); 
		
		que.add(new Area(x,y));
		
		while(!que.isEmpty()){
			Area a = que.poll();
			
			for(int i=0;i<4;i++){
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(nx >=0 && nx < N && ny >=0 && ny <M && (map[nx][ny] == 0 || map[nx][ny] ==2)){
					sum += valueCount(map[nx][ny]);
					map[nx][ny] = 3;
					que.add(new Area(nx,ny));
					
				}
			}
			
		}
		
		max = Math.max(sum,max);
	
	}
	
	public static int valueCount(int number){
		switch(number){
			case 0:
				return 1;
			case 2:
				return -2;
		}
		return 0;
	}
}

class Area{
	int x,y;
	
	Area(int x, int y){
		this.x = x;
		this.y = y;
	}
}
