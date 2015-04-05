import java.util.Scanner;


public class zigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = in.nextInt();
		getLS(a,n);
		in.close();
	}
	public static void getLS(int[] a,int n){
		int[] dp = new int[n];
		for(int i = 0;i < n;i++)dp[i] = 1;
		int[] tmp = new int[n];
		for(int i = 1;i < n;i++){
			int max = 0;
			for(int j = 0;j < i;j++){
				if(a[i]-a[j] > 0 && a[j]-a[tmp[j]] <= 0){
					int temp = dp[j] + 1;
					if(max < temp){
						dp[i] = temp;
						max = temp;
						tmp[i] = j;
					}
				}
				if(a[i]-a[j] < 0 && a[j]-a[tmp[j]] >= 0){
					int temp = dp[j] + 1;
					if(max < temp){
						dp[i] = temp;
						max = temp;
						tmp[i] = j;
					}
				}
			}
		}
		System.out.println("Longest Seq Size = "+dp[n-1]);
		//printAr(tmp);
		//printAr(dp);
		for(int i = 0;i < n;i++){
			if(i == 0)System.out.print(a[i]+" ");
			else if(dp[i] != dp[i-1])System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void printAr(int[] a){
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
