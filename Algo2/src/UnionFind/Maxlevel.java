package UnionFind;

import java.util.Scanner;

public class Maxlevel {
	
	public static  int root(int i[], int s){
		int j = 0;
		while(i[s] != s ){
			s = i[s];
			j++;
			//System.out.println(s);
		}
		
		return j;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int [10];
		
		for(int i = 0; i< 10;i++){
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i< 10; i++){
			System.out.println(root(arr, i));
		}
		
	}
}
