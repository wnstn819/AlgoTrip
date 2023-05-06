import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int a= sc.nextInt();
		int sum=2000;
		int count=0;
		int count2=0;
		if(a%5==0) {
			sum = a/5;
			System.out.println(a/5);
			return;
		}else if((a%5)%3 == 0) {
			System.out.println((a/5)+(a%5/3));
			return;
		}else if(a%3 == 0) {
			if(sum>(a/3)) {
				sum= a/3;
			}
		}  	while(a>0) {
				a=a-5;
				if(a<0) {
					if(sum==2000) {
					System.out.println("-1");
					return;
					}
				}
				count++;
				if(a%3==0) {
					if(a<0) {
						System.out.println(sum);
						return;
					}
					count2 = a/3;
					if(count+count2<sum) {
						sum=count+count2;
					}
			
				}
					
				}
			if(sum==2000) {
				System.out.println("-1");
				return;
				}


			
			System.out.println(sum);

		}
	}
	// System.out.println(a%b);



