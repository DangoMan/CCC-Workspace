package UnionFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QU {
	
	
	
	public static  int root(int i[], int s){
		while(i[s] != s ){
			s = i[s];
		}
		
		return s;
	}
	
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//file input
		Scanner sc = new Scanner(new File("src/UF.txt"));
		
		int arr[] = new int[10];
		int weight[] = new int[10];
		
		//initialize array 
		for(int i = 0; i< 10;i++){
			arr[i] = i;
			weight[i] =1;
		}
		
		
		while(sc.hasNextInt() == true){
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int ri = root(arr,i);
			int rj = root(arr,j);
			
			if(weight [ri] < weight [rj]){
				arr[ri] = rj; 
				
				weight [rj] += weight[ri];
			}
			
			else {
				arr[rj] = ri; 
				
				weight [ri] += weight[rj];
			}
			
			for(int ii = 0; ii< 10;ii++){
				System.out.print(arr[ii] + " ");
				
			}
			System.out.println();
		}
		
		for(int i = 0; i< 10;i++){
			System.out.println(arr[i]);
		}
	}
}
