import java.io.*;
import java.util.*;
class Main {
		static int max;
		static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		max = prev;
		int sum =prev;
		for(int i =1;i<n;i++){
			int m = Integer.parseInt(st.nextToken());
			if(m-1 == prev){ // 하나보다 작다면
				sum += m;
			}else{
				sum = m;
			}
			max = Math.max(sum,max);
				prev = m;
		}
		
		System.out.println(max);
	}
}